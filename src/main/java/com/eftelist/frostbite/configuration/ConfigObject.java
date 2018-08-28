package com.eftelist.frostbite.configuration;

public interface ConfigObject {

    String toConfig();

    Object fromString(String serialized);
}
