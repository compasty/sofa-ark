/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alipay.sofa.ark.boot.mojo;

import org.apache.maven.project.MavenProject;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

/**
 * @author yan (yanhuai.yh@antfin.com) 2023/10/17 2:25 下午
 * @since
 **/
public class MavenUtilsTest {

    @Test
    public void testRootProject() {
        Assert.assertTrue(MavenUtils.isRootProject(null));
        Assert.assertNull(MavenUtils.getRootProject(null));
        MavenProject project = new MavenProject();
        Assert.assertTrue(MavenUtils.isRootProject(project));
        MavenProject parentProject1 = new MavenProject();
        File f = new File(this.getClass().getClassLoader().getResource("test-jar.jar").getFile());
        parentProject1.setFile(f);
        project.setParent(parentProject1);
        Assert.assertFalse(MavenUtils.isRootProject(project));
        Assert.assertTrue(MavenUtils.isRootProject(parentProject1));
        Assert.assertEquals(MavenUtils.getRootProject(project), parentProject1);
    }
}