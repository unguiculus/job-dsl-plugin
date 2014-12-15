package javaposse.jobdsl.dsl

import com.google.common.base.Preconditions
import javaposse.jobdsl.dsl.helpers.Context

class ConfigFile implements Context {
    final ConfigFileType type
    String name
    String comment = ''
    String content = ''

    ConfigFile(ConfigFileType type) {
        this.type = type
    }

    void name(String name) {
        this.name = name
    }

    void comment(String comment) {
        Preconditions.checkArgument(comment != null, 'comment must not be null')

        this.comment = comment
    }

    void content(String content) {
        Preconditions.checkArgument(content != null, 'content must not be null')

        this.content = content
    }
}
