/**---------------------------------------------------------------------------------------------
 *  Copyright (c) Microsoft Corporation. All rights reserved.
 *  Licensed under the MIT License. See License.txt in the project root for license information.
 *--------------------------------------------------------------------------------------------*/

package com.microsoft.walletlibrary.mappings.issuance

import com.microsoft.did.sdk.credential.service.IssuanceRequest
import com.microsoft.walletlibrary.mappings.toRootOfTrust
import com.microsoft.walletlibrary.requests.ContractIssuanceRequest
import com.microsoft.walletlibrary.requests.styles.OpenIdRequesterStyle

private fun IssuanceRequest.getRequesterStyle(): OpenIdRequesterStyle {
    return OpenIdRequesterStyle(
        this.entityName,
        "",
        null
    )
}

internal fun IssuanceRequest.toContractIssuanceRequest(): ContractIssuanceRequest {
    return ContractIssuanceRequest(
        this.getRequesterStyle(),
        this.getAttestations().toRequirement(),
        this.linkedDomainResult.toRootOfTrust(),
        this.contract.display.toVerifiedIdStyle()
    )
}