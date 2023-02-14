package com.microsoft.walletlibrary.mappings

import com.microsoft.did.sdk.credential.service.models.presentationexchange.CredentialPresentationInputDescriptor
import com.microsoft.did.sdk.credential.service.models.presentationexchange.PresentationDefinition
import com.microsoft.did.sdk.credential.service.models.presentationexchange.Schema
import com.microsoft.walletlibrary.requests.requirements.GroupRequirement
import com.microsoft.walletlibrary.requests.requirements.GroupRequirementOperator
import com.microsoft.walletlibrary.requests.requirements.VerifiedIdRequirement
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class PresentationDefinitionMappingTest {
    private lateinit var presentationDefinition: PresentationDefinition
    private val expectedId = "TestDefinitionId"
    private val expectedInputDescriptor = mockk<CredentialPresentationInputDescriptor>()

    init {
        setupInput(listOf(expectedInputDescriptor))
    }

    private fun setupInput(expectedInputDescriptors: List<CredentialPresentationInputDescriptor>) {
        for (inputDescriptor in expectedInputDescriptors) {
            val expectedSchema = mockk<Schema>()
            every { inputDescriptor.schemas } returns listOf(expectedSchema)
            every { expectedSchema.uri } returns ""
            every { inputDescriptor.id } returns ""
            every { inputDescriptor.purpose } returns ""
            every { inputDescriptor.issuanceMetadataList } returns emptyList()
        }
        presentationDefinition = PresentationDefinition(expectedId, expectedInputDescriptors)
    }

    @Test
    fun presentationDefinitionMapping_WithOneInputDescriptor_ReturnsVerifiedIdRequirement() {
        // Act
        val expectedRequirement = presentationDefinition.toRequirement()

        // Assert
        assertThat(expectedRequirement).isInstanceOf(VerifiedIdRequirement::class.java)
        assertThat(expectedRequirement.required).isEqualTo(true)
    }

    @Test
    fun presentationDefinitionMapping_WithMultipleInputDescriptors_ReturnsGroupRequirement() {
        // Arrange
        val expectedInputDescriptor1 = mockk<CredentialPresentationInputDescriptor>()
        val expectedInputDescriptor2 = mockk<CredentialPresentationInputDescriptor>()
        setupInput(listOf(expectedInputDescriptor1, expectedInputDescriptor2))

        // Act
        val expectedRequirement = presentationDefinition.toRequirement()

        // Assert
        assertThat(expectedRequirement).isInstanceOf(GroupRequirement::class.java)
        assertThat(expectedRequirement.required).isEqualTo(true)
        assertThat((expectedRequirement as GroupRequirement).requirementOperator).isEqualTo(GroupRequirementOperator.ANY)
    }
}