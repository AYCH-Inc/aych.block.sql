/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_questdb_net_Win32SelectDispatcher */

#ifndef _Included_com_questdb_net_Win32SelectDispatcher
#define _Included_com_questdb_net_Win32SelectDispatcher
#ifdef __cplusplus
extern "C" {
#endif
#undef com_questdb_net_Win32SelectDispatcher_M_TIMESTAMP
#define com_questdb_net_Win32SelectDispatcher_M_TIMESTAMP 0L
#undef com_questdb_net_Win32SelectDispatcher_M_FD
#define com_questdb_net_Win32SelectDispatcher_M_FD 1L
#undef com_questdb_net_Win32SelectDispatcher_M_OPERATION
#define com_questdb_net_Win32SelectDispatcher_M_OPERATION 2L
#undef com_questdb_net_Win32SelectDispatcher_FD_READ
#define com_questdb_net_Win32SelectDispatcher_FD_READ 1L
#undef com_questdb_net_Win32SelectDispatcher_FD_WRITE
#define com_questdb_net_Win32SelectDispatcher_FD_WRITE 2L
/*
 * Class:     com_questdb_net_Win32SelectDispatcher
 * Method:    select
 * Signature: (JJJ)I
 */
JNIEXPORT jint JNICALL Java_com_questdb_net_Win32SelectDispatcher_select
        (JNIEnv *, jclass, jlong, jlong, jlong);

/*
 * Class:     com_questdb_net_Win32SelectDispatcher
 * Method:    countOffset
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_questdb_net_Win32SelectDispatcher_countOffset
        (JNIEnv *, jclass);

/*
 * Class:     com_questdb_net_Win32SelectDispatcher
 * Method:    arrayOffset
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_questdb_net_Win32SelectDispatcher_arrayOffset
        (JNIEnv *, jclass);

#ifdef __cplusplus
}
#endif
#endif
