/*
 * Copyright (C) 2009 The Android Open Source Project
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
 *
 */
#include <string.h>
#include <jni.h>

/* This is a trivial JNI example where we use a native method
 * to return a new VM String. See the corresponding Java source
 * file located at:
 *
 *   apps/samples/hello-jni/project/src/com/example/hellojni/HelloJni.java
 */
jstring
Java_com_mylp_ao_sgtba( JNIEnv* env,
                                                  jobject thiz )
{
#if defined(__arm__)
  #if defined(__ARM_ARCH_7A__)
    #if defined(__ARM_NEON__)
      #define ABI "armeabi-v7a/NEON"
    #else
      #define ABI "armeabi-v7a"
    #endif
  #else
   #define ABI "armeabi"
  #endif
#elif defined(__i386__)
   #define ABI "x86"
#elif defined(__mips__)
   #define ABI "mips"
#else
   #define ABI "unknown"
#endif

    return (*env)->NewStringUTF(env, "aHR0cHM6Ly9pdGVtLnRhb2Jhby5jb20vaXRlbS5odG0/c3BtPWEyMzByLjcxOTUxOTMuMTk5NzA3OTM5Ny44LnBES1M4UiZpZD01MjA5NTEzMDg5NzgmYWJidWNrZXQ9MTE");
}
jstring
Java_com_mylp_ao_sgtbb( JNIEnv* env,
                                                  jobject thiz )
{
#if defined(__arm__)
  #if defined(__ARM_ARCH_7A__)
    #if defined(__ARM_NEON__)
      #define ABI "armeabi-v7a/NEON"
    #else
      #define ABI "armeabi-v7a"
    #endif
  #else
   #define ABI "armeabi"
  #endif
#elif defined(__i386__)
   #define ABI "x86"
#elif defined(__mips__)
   #define ABI "mips"
#else
   #define ABI "unknown"
#endif

    return (*env)->NewStringUTF(env, "aHR0cHM6Ly9pdGVtLnRhb2Jhby5jb20vaXRlbS5odG0/c3BtPWExejEwLjEtYy53NDAwNC0xMTc5MTc0NTY2Mi40LlZRTjZhNSZpZD01MjA5NTE1MTY1NDU");
}
jstring
Java_com_mylp_ao_sgtbc( JNIEnv* env,
                                                  jobject thiz )
{
#if defined(__arm__)
  #if defined(__ARM_ARCH_7A__)
    #if defined(__ARM_NEON__)
      #define ABI "armeabi-v7a/NEON"
    #else
      #define ABI "armeabi-v7a"
    #endif
  #else
   #define ABI "armeabi"
  #endif
#elif defined(__i386__)
   #define ABI "x86"
#elif defined(__mips__)
   #define ABI "mips"
#else
   #define ABI "unknown"
#endif

    return (*env)->NewStringUTF(env, "aHR0cHM6Ly9pdGVtLnRhb2Jhby5jb20vaXRlbS5odG0/c3BtPWExejEwLjEtYy53NDAwNC0xMTc5MTc0NTY2Mi44LlZRTjZhNSZpZD01MjA5NTE2MjgzOTE");
}
jstring
Java_com_mylp_ao_sgtbd( JNIEnv* env,
                                                  jobject thiz )
{
#if defined(__arm__)
  #if defined(__ARM_ARCH_7A__)
    #if defined(__ARM_NEON__)
      #define ABI "armeabi-v7a/NEON"
    #else
      #define ABI "armeabi-v7a"
    #endif
  #else
   #define ABI "armeabi"
  #endif
#elif defined(__i386__)
   #define ABI "x86"
#elif defined(__mips__)
   #define ABI "mips"
#else
   #define ABI "unknown"
#endif

    return (*env)->NewStringUTF(env, "aHR0cHM6Ly9pdGVtLnRhb2Jhby5jb20vaXRlbS5odG0/c3BtPWExejEwLjEtYy53NDAwNC0xMTc5MTc0NTY2Mi4xMC5WUU42YTUmaWQ9NTIwOTUxNTk4OTQ4");
}
jstring
Java_com_mylp_ao_sgtbe( JNIEnv* env,
                                                  jobject thiz )
{
#if defined(__arm__)
  #if defined(__ARM_ARCH_7A__)
    #if defined(__ARM_NEON__)
      #define ABI "armeabi-v7a/NEON"
    #else
      #define ABI "armeabi-v7a"
    #endif
  #else
   #define ABI "armeabi"
  #endif
#elif defined(__i386__)
   #define ABI "x86"
#elif defined(__mips__)
   #define ABI "mips"
#else
   #define ABI "unknown"
#endif

    return (*env)->NewStringUTF(env, "aHR0cHM6Ly9pdGVtLnRhb2Jhby5jb20vaXRlbS5odG0/c3BtPWExejEwLjEtYy53NDAwNC0xMTc5MTc0NTY2Mi4xMC5Ncm5Ka3YmaWQ9NTIwOTUxNDA4OTY1");
}
jstring
Java_com_mylp_ao_sgtbf( JNIEnv* env,
                                                  jobject thiz )
{
#if defined(__arm__)
  #if defined(__ARM_ARCH_7A__)
    #if defined(__ARM_NEON__)
      #define ABI "armeabi-v7a/NEON"
    #else
      #define ABI "armeabi-v7a"
    #endif
  #else
   #define ABI "armeabi"
  #endif
#elif defined(__i386__)
   #define ABI "x86"
#elif defined(__mips__)
   #define ABI "mips"
#else
   #define ABI "unknown"
#endif

    return (*env)->NewStringUTF(env, "aHR0cHM6Ly9pdGVtLnRhb2Jhby5jb20vaXRlbS5odG0/c3BtPWExejEwLjEtYy53NDAwNC0xMTc5MTc0NTY2Mi4xOC5WUU42YTUmaWQ9NTIwOTUxMzUyODA2");
}
jstring
Java_com_mylp_ao_sgtbg( JNIEnv* env,
                                                  jobject thiz )
{
#if defined(__arm__)
  #if defined(__ARM_ARCH_7A__)
    #if defined(__ARM_NEON__)
      #define ABI "armeabi-v7a/NEON"
    #else
      #define ABI "armeabi-v7a"
    #endif
  #else
   #define ABI "armeabi"
  #endif
#elif defined(__i386__)
   #define ABI "x86"
#elif defined(__mips__)
   #define ABI "mips"
#else
   #define ABI "unknown"
#endif

    return (*env)->NewStringUTF(env, "aHR0cHM6Ly9pdGVtLnRhb2Jhby5jb20vaXRlbS5odG0/c3BtPWExejEwLjEtYy53NDAwNC0xMTc5MTc0NTY2Mi4yNi5WUU42YTUmaWQ9NTIwOTQ4NjkzNDk4");
}
jstring
Java_com_mylp_ao_sgtbh( JNIEnv* env,
                                                  jobject thiz )
{
#if defined(__arm__)
  #if defined(__ARM_ARCH_7A__)
    #if defined(__ARM_NEON__)
      #define ABI "armeabi-v7a/NEON"
    #else
      #define ABI "armeabi-v7a"
    #endif
  #else
   #define ABI "armeabi"
  #endif
#elif defined(__i386__)
   #define ABI "x86"
#elif defined(__mips__)
   #define ABI "mips"
#else
   #define ABI "unknown"
#endif

    return (*env)->NewStringUTF(env, "aHR0cHM6Ly9pdGVtLnRhb2Jhby5jb20vaXRlbS5odG0/c3BtPWExejEwLjEtYy53NDAwNC0xMTc5MTc0NTY2Mi4yNC5WUU42YTUmaWQ9NTIwOTQ4NzEzMzc4");
}
jstring
Java_com_mylp_ao_sgtbi( JNIEnv* env,
                                                  jobject thiz )
{
#if defined(__arm__)
  #if defined(__ARM_ARCH_7A__)
    #if defined(__ARM_NEON__)
      #define ABI "armeabi-v7a/NEON"
    #else
      #define ABI "armeabi-v7a"
    #endif
  #else
   #define ABI "armeabi"
  #endif
#elif defined(__i386__)
   #define ABI "x86"
#elif defined(__mips__)
   #define ABI "mips"
#else
   #define ABI "unknown"
#endif

    return (*env)->NewStringUTF(env, "aHR0cHM6Ly9pdGVtLnRhb2Jhby5jb20vaXRlbS5odG0/c3BtPWExejEwLjEtYy53NDAwNC0xMTc5MTc0NTY2Mi4yNC5Ncm5Ka3YmaWQ9NTIwOTQ4NzQ1MTk4");
}

jstring
Java_com_mylp_ao_sgtbj( JNIEnv* env,
                                                  jobject thiz )
{
#if defined(__arm__)
  #if defined(__ARM_ARCH_7A__)
    #if defined(__ARM_NEON__)
      #define ABI "armeabi-v7a/NEON"
    #else
      #define ABI "armeabi-v7a"
    #endif
  #else
   #define ABI "armeabi"
  #endif
#elif defined(__i386__)
   #define ABI "x86"
#elif defined(__mips__)
   #define ABI "mips"
#else
   #define ABI "unknown"
#endif

    return (*env)->NewStringUTF(env, "5Li65L+d5oyB5Lyg5oSf5Zmo55qE56iz5a6a5oCn77yM5L2/55So5bqU55So5pe26K+36YG/5YWN5L2/55So5bim56OB6ZOB55qE5omL5py65aOz77yM5aaC5p6c5L2g5Zac5qyi5q2k5bqU55So5bm25biM5pyb5bqU55So5pu05paw77yM6K+35YWz5rOo5reY5a6d5bqX6ZO64oCc5rOw6L6+5riv5pWw56CB5bqX4oCd77yM5oiR5Lus5bCG5Lya5Zyo5YWz5rOo5Lq65pWw6L6+5YiwMeS4h+S6uuS5i+WQjui/m+ihjOabtOaWsO+8jOWmguaenOS9v+eUqOi/h+eoi+S4reWPkeeOsOmXrumimO+8jOWPr+S7peWIsOeZvuW6pui0tOWQp+KAnOeyvuWTgee9l+ebmOKAneWQp+i/m+ihjOWPjemmiOW7uuiurg");
}

jstring
Java_com_mylp_ao_sgtbk( JNIEnv* env,
                                                  jobject thiz )
{
#if defined(__arm__)
  #if defined(__ARM_ARCH_7A__)
    #if defined(__ARM_NEON__)
      #define ABI "armeabi-v7a/NEON"
    #else
      #define ABI "armeabi-v7a"
    #endif
  #else
   #define ABI "armeabi"
  #endif
#elif defined(__i386__)
   #define ABI "x86"
#elif defined(__mips__)
   #define ABI "mips"
#else
   #define ABI "unknown"
#endif

	return (*env)->NewStringUTF(env, "aHR0cHM6Ly90YWlkYWdhbmcudGFvYmFvLmNvbQ");
}
jstring
Java_com_mylp_ao_sgtbl( JNIEnv* env,
                                                  jobject thiz )
{
#if defined(__arm__)
  #if defined(__ARM_ARCH_7A__)
    #if defined(__ARM_NEON__)
      #define ABI "armeabi-v7a/NEON"
    #else
      #define ABI "armeabi-v7a"
    #endif
  #else
   #define ABI "armeabi"
  #endif
#elif defined(__i386__)
   #define ABI "x86"
#elif defined(__mips__)
   #define ABI "mips"
#else
   #define ABI "unknown"
#endif

	return (*env)->NewStringUTF(env, "5Y+N6aaI5bu66K6u");
}
jstring
Java_com_mylp_ao_sgtbm( JNIEnv* env,
                                                  jobject thiz )
{
#if defined(__arm__)
  #if defined(__ARM_ARCH_7A__)
    #if defined(__ARM_NEON__)
      #define ABI "armeabi-v7a/NEON"
    #else
      #define ABI "armeabi-v7a"
    #endif
  #else
   #define ABI "armeabi"
  #endif
#elif defined(__i386__)
   #define ABI "x86"
#elif defined(__mips__)
   #define ABI "mips"
#else
   #define ABI "unknown"
#endif

    return (*env)->NewStringUTF(env, "54K55Ye76L+b5YWl");
}

jstring
Java_com_mylp_ao_sgtbn( JNIEnv* env,
                                                  jobject thiz )
{
#if defined(__arm__)
  #if defined(__ARM_ARCH_7A__)
    #if defined(__ARM_NEON__)
      #define ABI "armeabi-v7a/NEON"
    #else
      #define ABI "armeabi-v7a"
    #endif
  #else
   #define ABI "armeabi"
  #endif
#elif defined(__i386__)
   #define ABI "x86"
#elif defined(__mips__)
   #define ABI "mips"
#else
   #define ABI "unknown"
#endif

    return (*env)->NewStringUTF(env, "54K55Ye76YCA5Ye6");
}


