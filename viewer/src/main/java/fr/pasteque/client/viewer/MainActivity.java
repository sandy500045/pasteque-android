package fr.pasteque.client.viewer;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import fr.pasteque.api.API;
import fr.pasteque.api.Tickets;

/**
 * Created by svirch_n on 07/04/16
 * Last edited at 17:01.
 */
public class MainActivity extends FragmentActivity {

    private static final int MENU_CONFIG_ID = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        API api = new API(Pasteque.getConfiguration());
        Log.d("Pasteque", api.Tickets.getAllSharedTicket());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuItem config = menu.add(Menu.NONE, MENU_CONFIG_ID, 1,
                this.getString(R.string.menu_config));
        config.setIcon(R.drawable.ico_reglage);
        config.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == MENU_CONFIG_ID) {
            Intent i = new Intent(this, Configure.class);
            this.startActivity(i);
            return true;
        }
        return false;
    }
}