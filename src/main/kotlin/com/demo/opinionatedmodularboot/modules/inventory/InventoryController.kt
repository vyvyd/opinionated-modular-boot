package com.demo.opinionatedmodularboot.modules.inventory

import com.demo.opinionatedmodularboot.modules.replacement.ReplacementService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class InventoryController(
    private val replacementService: ReplacementService,
    private val inventoryService: InventoryService
) {

    @GetMapping("/inventory")
    fun controllerMethod() {
        this.inventoryService.action()
        this.replacementService.action()
    }
}


