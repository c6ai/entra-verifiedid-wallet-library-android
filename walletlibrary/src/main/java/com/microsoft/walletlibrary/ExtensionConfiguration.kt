/*---------------------------------------------------------------------------------------------
*  Copyright (c) Microsoft Corporation. All rights reserved.
*  Licensed under the MIT License. See License.txt in the project root for license information.
*--------------------------------------------------------------------------------------------*/

package com.microsoft.walletlibrary

import com.microsoft.walletlibrary.util.LibraryConfiguration
import com.microsoft.walletlibrary.util.WalletLibraryLogger

/**
 * Utilities such as logger, identityManager that are configured in builder and
 * all of library will use.
 */
class ExtensionConfiguration private constructor(
    /**
     * Logs and metrics class
     */
    val logger: WalletLibraryLogger,
    /**
     * Identifier manager for extension use
     */
    val identifierManager: ExtensionIdentifierManager
) {

    internal constructor(libraryConfiguration: LibraryConfiguration) : this(
        libraryConfiguration.logger,
        ExtensionIdentifierManager(libraryConfiguration.identifierManager, libraryConfiguration.tokenSigner, libraryConfiguration.serializer)
    )
}
