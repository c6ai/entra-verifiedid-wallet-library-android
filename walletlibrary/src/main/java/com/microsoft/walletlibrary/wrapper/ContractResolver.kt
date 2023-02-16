/**---------------------------------------------------------------------------------------------
 *  Copyright (c) Microsoft Corporation. All rights reserved.
 *  Licensed under the MIT License. See License.txt in the project root for license information.
 *--------------------------------------------------------------------------------------------*/

package com.microsoft.walletlibrary.wrapper

import com.microsoft.did.sdk.VerifiableCredentialSdk
import com.microsoft.did.sdk.util.controlflow.Result
import com.microsoft.walletlibrary.mappings.issuance.toContractIssuanceRequest
import com.microsoft.walletlibrary.requests.ContractIssuanceRequest
import com.microsoft.walletlibrary.util.VerifiedIdRequestFetchException

/**
 * Wrapper class to wrap the get Issuance Request from VC SDK and return a raw request.
 */
object ContractResolver {

    // Fetches the issuance request from VC SDK using the url and converts it to raw request.
    internal suspend fun getIssuanceRequest(uri: String): ContractIssuanceRequest {
        return when (val issuanceRequestResult =
            VerifiableCredentialSdk.issuanceService.getRequest(uri)) {
            is Result.Success -> {
                val request = issuanceRequestResult.payload
                request.toContractIssuanceRequest()
            }
            is Result.Failure -> {
                throw VerifiedIdRequestFetchException(
                    "Unable to fetch issuance request",
                    issuanceRequestResult.payload
                )
            }
        }
    }
}