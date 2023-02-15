/**---------------------------------------------------------------------------------------------
 *  Copyright (c) Microsoft Corporation. All rights reserved.
 *  Licensed under the MIT License. See License.txt in the project root for license information.
 *--------------------------------------------------------------------------------------------*/

package com.microsoft.walletlibrary.mappings

import com.microsoft.did.sdk.credential.service.PresentationRequest
import com.microsoft.walletlibrary.requests.OpenIdPresentationRequest
import com.microsoft.walletlibrary.requests.styles.Logo
import com.microsoft.walletlibrary.requests.styles.OpenIdRequesterStyle

internal fun PresentationRequest.toRequesterStyle(): OpenIdRequesterStyle {
    val registration = this.content.registration
    return OpenIdRequesterStyle(
        this.entityName,
        "",
        Logo(registration.logoUri, registration.logoData, "")
    )
}

internal fun PresentationRequest.toOpenIdPresentationRequest(): OpenIdPresentationRequest {
    return OpenIdPresentationRequest(
        this.toRequesterStyle(),
        this.getPresentationDefinition().toRequirement(),
        this.linkedDomainResult.toRootOfTrust()
    )
}