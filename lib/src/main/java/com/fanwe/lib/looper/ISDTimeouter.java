/*
 * Copyright (C) 2017 zhengjun, fanwe (http://www.fanwe.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fanwe.lib.looper;

public interface ISDTimeouter
{
    /**
     * 默认超时
     */
    long DEFAULT_TIMEOUT = 10 * 1000;

    /**
     * 获得设置的超时时间
     */
    long getTimeout();

    /**
     * 是否超时
     */
    boolean isTimeout();

    /**
     * 设置超时需要执行的Runnable
     */
    ISDTimeouter setTimeoutRunnable(Runnable timeoutRunnable);

    /**
     * 执行超时需要执行的Runnable
     */
    ISDTimeouter runTimeoutRunnable();

    /**
     * 设置超时时间
     *
     * @param timeout 大于0超时才有效
     * @return
     */
    ISDTimeouter setTimeout(long timeout);

    /**
     * 开始超时计时
     */
    ISDTimeouter startTimeout();

    /**
     * 停止超时计时
     */
    ISDTimeouter stopTimeout();
}