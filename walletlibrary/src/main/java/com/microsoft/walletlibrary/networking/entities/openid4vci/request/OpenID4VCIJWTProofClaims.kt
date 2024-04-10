package com.microsoft.walletlibrary.networking.entities.openid4vci.request

import kotlinx.serialization.Serializable

<<<<<<< HEAD
=======
/**
 * Claims in the Issuance request token.
 */
>>>>>>> dev
@Serializable
internal data class OpenID4VCIJWTProofClaims(
    val aud: String,
    val iat: String,
    val sub: String,
    val at_hash: String,
    val exp: String? = null,
    val nbf: String? = null
)