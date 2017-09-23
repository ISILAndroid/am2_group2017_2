package com.isil.am2template;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.isil.am2template.storage.PreferencesHelper;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        //assertEquals("com.isil.am2template", appContext.getPackageName());

        //guardar sessión
        //PreferencesHelper.saveSession(appContext,"edu","123456");
        PreferencesHelper.signOut(appContext);
        boolean session=PreferencesHelper.isSignedIn(appContext);
        assertEquals(false,session);
    }
}
