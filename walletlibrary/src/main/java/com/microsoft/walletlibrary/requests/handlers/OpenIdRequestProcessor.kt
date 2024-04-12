/**---------------------------------------------------------------------------------------------
 *  Copyright (c) Microsoft Corporation. All rights reserved.
 *  Licensed under the MIT License. See License.txt in the project root for license information.
 *--------------------------------------------------------------------------------------------*/

package com.microsoft.walletlibrary.requests.handlers

import com.microsoft.walletlibrary.did.sdk.identifier.resolvers.RootOfTrustResolver
import com.microsoft.walletlibrary.mappings.issuance.toVerifiedIdStyle
import com.microsoft.walletlibrary.requests.ManifestIssuanceRequest
import com.microsoft.walletlibrary.requests.OpenIdPresentationRequest
import com.microsoft.walletlibrary.requests.PresentationRequestContent
import com.microsoft.walletlibrary.requests.VerifiedIdPartialRequest
import com.microsoft.walletlibrary.requests.VerifiedIdRequest
import com.microsoft.walletlibrary.requests.input.VerifiedIdRequestURL
import com.microsoft.walletlibrary.requests.rawrequests.OpenIdProcessedRequest
import com.microsoft.walletlibrary.requests.rawrequests.OpenIdRawRequest
import com.microsoft.walletlibrary.requests.rawrequests.RawManifest
import com.microsoft.walletlibrary.requests.rawrequests.RequestType
import com.microsoft.walletlibrary.requests.rawrequests.VerifiedIdOpenIdJwtRawRequest
import com.microsoft.walletlibrary.requests.requestProcessorExtensions.RequestProcessorExtension
import com.microsoft.walletlibrary.requests.requirements.VerifiedIdRequirement
import com.microsoft.walletlibrary.util.InputCastingException
import com.microsoft.walletlibrary.util.LibraryConfiguration
import com.microsoft.walletlibrary.util.PreviewFeatureFlags
import com.microsoft.walletlibrary.util.RequirementCastingException
import com.microsoft.walletlibrary.util.UnSupportedProtocolException
import com.microsoft.walletlibrary.verifiedid.VerifiedId
import com.microsoft.walletlibrary.wrapper.ManifestResolver

/**
 * OIDC protocol specific implementation of RequestProcessor. It can handle OpenID raw request and returns a VerifiedIdRequest.
 */
class OpenIdRequestProcessor internal constructor(private val libraryConfiguration: LibraryConfiguration): RequestProcessor<OpenIdRawRequest> {

<<<<<<< HEAD:walletlibrary/src/main/java/com/microsoft/walletlibrary/requests/handlers/OpenIdRequestHandler.kt
    // Indicates whether the provided raw request can be handled by this handler.
    override fun canHandle(rawRequest: Any): Boolean {
        return rawRequest is OpenIdRawRequest
=======

    /**
     * Extensions to this RequestProcessor. All extensions should be called after initial request
     * processing to mutate the request with additional input.
     */
    override var requestProcessors: MutableList<RequestProcessorExtension<OpenIdRawRequest>> = mutableListOf()

    /**
     * Checks if the input can be processed
     * @param rawRequest A primitive form of the request
     * @return if the input is understood by the processor and can be processed
     */
    override suspend fun canHandleRequest(rawRequest: Any): Boolean {
        // TODO: This and handleRequest need to be refactored to accept a string.
        return rawRequest is VerifiedIdOpenIdJwtRawRequest
>>>>>>> logirvin/facecheck-v2:walletlibrary/src/main/java/com/microsoft/walletlibrary/requests/handlers/OpenIdRequestProcessor.kt
    }

    // Handle and process the provided raw request and returns a VerifiedIdRequest.
    override suspend fun handleRequest(rawRequest: Any, rootOfTrustResolver: RootOfTrustResolver?): VerifiedIdRequest<*> {
<<<<<<< HEAD:walletlibrary/src/main/java/com/microsoft/walletlibrary/requests/handlers/OpenIdRequestHandler.kt
        if (rawRequest !is OpenIdRawRequest)
=======
        if (rawRequest !is VerifiedIdOpenIdJwtRawRequest)
>>>>>>> logirvin/facecheck-v2:walletlibrary/src/main/java/com/microsoft/walletlibrary/requests/handlers/OpenIdRequestProcessor.kt
            throw UnSupportedProtocolException("Received a raw request of unsupported protocol")
        val presentationRequestContent = rawRequest.mapToPresentationRequestContent()
        return if (rawRequest.requestType == RequestType.ISSUANCE)
            handleIssuanceRequest(presentationRequestContent, rootOfTrustResolver)
        else
            handlePresentationRequest(presentationRequestContent, rawRequest)
    }

    private fun handlePresentationRequest(
        presentationRequestContent: PresentationRequestContent,
        rawRequest: OpenIdProcessedRequest
    ): VerifiedIdRequest<Unit> {
        var partialRequest = VerifiedIdPartialRequest(
            presentationRequestContent.requesterStyle,
            presentationRequestContent.requirement,
            presentationRequestContent.rootOfTrust
        )
        if (libraryConfiguration.isPreviewFeatureEnabled(PreviewFeatureFlags.FEATURE_FLAG_PROCESSOR_EXTENSION_SUPPORT)) {
            this.requestProcessors.forEach { extension ->
                partialRequest = extension.parse(
                    rawRequest.rawRequest,
                    partialRequest
                )
            }
        }
        return OpenIdPresentationRequest(
            partialRequest.requesterStyle,
            partialRequest.requirement,
            partialRequest.rootOfTrust,
            rawRequest,
            libraryConfiguration
        )
    }

    private suspend fun handleIssuanceRequest(
        presentationRequestContent: PresentationRequestContent,
        rootOfTrustResolver: RootOfTrustResolver? = null
    ): VerifiedIdRequest<VerifiedId> {
        validateRequirement(presentationRequestContent)
        val contractUrl =
            ((presentationRequestContent.requirement as VerifiedIdRequirement).issuanceOptions.first() as VerifiedIdRequestURL).url
        val rawManifest = getIssuanceRequest(
            contractUrl.toString(),
            presentationRequestContent.requestState,
            presentationRequestContent.issuanceCallbackUrl,
            rootOfTrustResolver
        )
        val issuanceRequestContent = rawManifest.mapToIssuanceRequestContent()
        presentationRequestContent.injectedIdToken?.let {
            issuanceRequestContent.addRequirementsForIdTokenHint(
                it
            )
        }
        return ManifestIssuanceRequest(
            issuanceRequestContent.requesterStyle,
            issuanceRequestContent.requirement,
            issuanceRequestContent.rootOfTrust,
            rawManifest.rawRequest.contract.display.toVerifiedIdStyle(),
            rawManifest,
            presentationRequestContent.issuanceCallbackUrl,
            presentationRequestContent.requestState
        )
    }

    private fun validateRequirement(requestContent: PresentationRequestContent) {
        if (requestContent.requirement !is VerifiedIdRequirement)
            throw RequirementCastingException("Requirement is not the expected VerifiedId Requirement")
        if ((requestContent.requirement as VerifiedIdRequirement).issuanceOptions.first() !is VerifiedIdRequestURL)
            throw InputCastingException("VerifiedId Input is not the expected VerifiedIdRequestURL type")
    }

    private suspend fun getIssuanceRequest(
        contractUrl: String,
        requestState: String?,
        issuanceCallbackUrl: String?,
        rootOfTrustResolver: RootOfTrustResolver? = null
    ): RawManifest {
        return ManifestResolver.getIssuanceRequest(contractUrl, requestState, issuanceCallbackUrl, rootOfTrustResolver)
    }
}