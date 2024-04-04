package com.microsoft.walletlibrary.networking.operations

import com.microsoft.walletlibrary.did.sdk.datasource.network.apis.HttpAgentApiProvider
import com.microsoft.walletlibrary.util.defaultTestSerializer
import com.microsoft.walletlibrary.util.http.httpagent.IResponse
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class PostOpenID4VCINetworkOperationTest {
    private val expectedVerifiableCredential = """"""

    @Test
    fun postOpenID4VCINetworkOperationTest_PostIssuanceRequest_ReturnsVerifiableCredential() {
        // Arrange
        val apiProvider: HttpAgentApiProvider = mockk {
            every { openId4VciApi } returns mockk {
                coEvery { postOpenID4VCIRequest(any(), any(), any()) } returns Result.success(
                    IResponse(
                        status = 200,
                        headers = emptyMap(),
                        body = expectedVerifiableCredential.toByteArray(Charsets.UTF_8)
                    )
                )
            }
        }
        val operation = PostOpenID4VCINetworkOperation("", "", "", apiProvider, defaultTestSerializer)

        runBlocking {
            // Act
            val actual = operation.fire()

            // Assert
            assertThat(actual.isSuccess).isTrue
            val unwrapped = actual.getOrThrow().credential
            assertThat(unwrapped).isEqualTo(expectedVerifiableCredential)
        }
    }
}