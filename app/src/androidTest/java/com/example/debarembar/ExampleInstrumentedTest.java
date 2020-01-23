package com.example.debarembar;

import android.content.Context;
import android.util.Log;

import androidx.room.Room;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.debarembar.controller.ProductDao;
import com.example.debarembar.model.Banco;
import com.example.debarembar.model.Bar;
import com.example.debarembar.model.Product;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    Context appContext;

    @Test
    public void useAppContext() {
        // Context of the app under test.
        appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.example.debarembar", appContext.getPackageName());
    }

    @Test
    public void arrayBar() {
        useAppContext();
        ArrayList<Bar> barList = new ArrayList<Bar>();
        Product coca = new Product(00, "coca", 10.00f);
        ArrayList<List> retorno = new ArrayList<List>();
        Bar bar0 = new Bar(00, "Bar do Zé", "esquina 1", 00);
        Bar bar1 = new Bar(01, "Bar do Zico", "esquina 2", 00);
        //Log.e("Bar",  );
        barList.add(bar0);
        barList.add(bar1);

        Banco db = Room.databaseBuilder(appContext,
                Banco.class, "DB").build();

            db.barDao().deleteAll(barList);
            db.barDao().insertAll(barList);
            db.barDao().delete(bar0);

            List<Bar> result = db.barDao().getAll();
            retorno.add(result);
        assertEquals(bar1, result.get(1));
    }
}
