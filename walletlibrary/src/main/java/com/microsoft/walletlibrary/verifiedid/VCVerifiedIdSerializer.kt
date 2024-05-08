package com.microsoft.walletlibrary.verifiedid

object VCVerifiedIdSerializer : VerifiedIdSerializer<com.microsoft.walletlibrary.did.sdk.credential.models.VerifiableCredential> {
    /**
     * Serialize the given verifiedID into the SerializedFormat
     */
    override fun serialize(verifiedId: VerifiedId): com.microsoft.walletlibrary.did.sdk.credential.models.VerifiableCredential {
        return when (verifiedId) {
            is VerifiableCredential -> {
                verifiedId.raw
            }

            is OpenId4VciVerifiedId -> {
                verifiedId.raw
            }

            else -> {
                throw VerifiedIdSerializer.VerifiedIdSerializationNotSupported()
            }
        }
    }
}