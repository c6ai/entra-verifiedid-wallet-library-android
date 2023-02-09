package com.microsoft.walletlibrary.requests

import com.microsoft.walletlibrary.VerifiedIdClientInput
import com.microsoft.walletlibrary.requests.resolvers.RequestResolver
import com.microsoft.walletlibrary.util.ResolverMissingException
import com.microsoft.walletlibrary.util.UnSupportedInputException
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions
import org.junit.Test

class RequestResolverFactoryTest {
    private val mockRequestResolver: RequestResolver = mockk()
    private val requestResolverFactory = RequestResolverFactory()
    private val mockVerifiedIdClientInput: VerifiedIdClientInput = mockk()

    private fun hasCompatibleResolver() {
        every { mockRequestResolver.canResolve(mockVerifiedIdClientInput) } returns true
    }

    private fun doesNotHaveCompatibleResolver(mockRequestResolver: RequestResolver) {
        every { mockRequestResolver.canResolve(mockVerifiedIdClientInput) } returns false
    }

    @Test
    fun resolver_RegisterOneHandler_Succeeds() {
        // Arrange
        requestResolverFactory.requestResolvers.add(mockRequestResolver)
        hasCompatibleResolver()

        // Act
        val actualResult = requestResolverFactory.getResolver(mockVerifiedIdClientInput)

        // Assert
        Assertions.assertThat(actualResult).isEqualTo(mockRequestResolver)
    }

    @Test
    fun resolver_NoResolverRegistration_Throws() {
        // Act and Assert
        Assertions.assertThatThrownBy { requestResolverFactory.getResolver(mockVerifiedIdClientInput) }
            .isInstanceOf(
                ResolverMissingException::class.java
            )
    }

    @Test
    fun resolver_NoCompatibleResolver_Throws() {
        // Arrange
        requestResolverFactory.requestResolvers.add(mockRequestResolver)
        doesNotHaveCompatibleResolver(mockRequestResolver)

        // Act and Assert
        Assertions.assertThatThrownBy { requestResolverFactory.getResolver(mockVerifiedIdClientInput) }
            .isInstanceOf(
                UnSupportedInputException::class.java
            )
    }

    @Test
    fun resolver_RegisterMultipleResolver_Succeeds() {
        // Arrange
        val secondMockRequestResolver: RequestResolver = mockk()
        requestResolverFactory.requestResolvers.add(mockRequestResolver)
        requestResolverFactory.requestResolvers.add(secondMockRequestResolver)
        hasCompatibleResolver()
        doesNotHaveCompatibleResolver(secondMockRequestResolver)

        // Act
        val actualResult = requestResolverFactory.getResolver(mockVerifiedIdClientInput)

        // Assert
        Assertions.assertThat(actualResult).isEqualTo(mockRequestResolver)
    }
}
