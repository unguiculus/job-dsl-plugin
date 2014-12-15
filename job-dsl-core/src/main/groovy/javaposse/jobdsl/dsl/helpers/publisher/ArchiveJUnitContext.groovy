package javaposse.jobdsl.dsl.helpers.publisher

import javaposse.jobdsl.dsl.DslContext
import javaposse.jobdsl.dsl.JobManagement
import javaposse.jobdsl.dsl.helpers.Context
import javaposse.jobdsl.dsl.helpers.ContextHelper

class ArchiveJUnitContext implements Context {
    final TestDataPublishersContext testDataPublishersContext
    boolean retainLongStdout = false

    ArchiveJUnitContext(JobManagement jobManagement) {
        testDataPublishersContext = new TestDataPublishersContext(jobManagement)
    }

    void retainLongStdout(boolean retain = true) {
        retainLongStdout = retain
    }

    void testDataPublishers(@DslContext(TestDataPublishersContext) Closure testDataPublishersClosure) {
        ContextHelper.executeInContext(testDataPublishersClosure, testDataPublishersContext)
    }
}
