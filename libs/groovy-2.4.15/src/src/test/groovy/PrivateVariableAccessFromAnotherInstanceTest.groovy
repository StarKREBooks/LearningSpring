/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package groovy

/**
 * test to ensure that private instance variables are visible to 
 * other instance variables of the same class
 * 
 * @author <a href="mailto:jeremy.rayner@bigfoot.com">Jeremy Rayner</a>
 */

class PrivateVariableAccessFromAnotherInstanceTest extends GroovyTestCase implements Cloneable { 
    def foo
    private def bar
              
    public PrivateVariableAccessFromAnotherInstanceTest() {
        super()
        foo = "foo"
        bar = "bar"
    }
              
    public Object clone() {
        def result = new PrivateVariableAccessFromAnotherInstanceTest()
        result.foo = foo
        result.bar = bar
        return result
    }
    
    void testClone() {
        def fred = new PrivateVariableAccessFromAnotherInstanceTest()

        def barney = fred.clone()


        assert !(barney.is(fred))
    }
} 
