package com.demo.opinionatedmodularboot.modules.inventory

import com.demo.opinionatedmodularboot.modules.ModuleAPI
import com.demo.opinionatedmodularboot.modules.replacement.ReplacementService
import org.springframework.stereotype.Service

class InventoryController(
    private val replacementService: ReplacementService,
    private val inventoryService: InventoryService
) {

    fun hello() {
//        this.inventoryService.action()
        this.replacementService.something()
    }
}


class InventoryService() {

    fun action() {

    }
}