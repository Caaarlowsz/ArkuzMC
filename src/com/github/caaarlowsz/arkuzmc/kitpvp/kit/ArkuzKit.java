package com.github.caaarlowsz.arkuzmc.kitpvp.kit;

import com.github.caaarlowsz.kitpvpapi.Kit;

public class ArkuzKit implements Kit {

    private final String name;

    public ArkuzKit(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}