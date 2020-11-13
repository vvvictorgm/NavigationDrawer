package com.barbaburguer.navigationdrawer;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Cria referencia para toda a área do NavigationDrawer
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        //Cria referencia para a área de navegação(menu lateral)
        NavigationView navigationView = findViewById(R.id.nav_view);

        //Define as configurações do NavigationDrawer
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send, R.id.nav_contato)
                .setDrawerLayout(drawer)
                .build();

        //Configura a área dos fragments
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        //Configura o menu (as tres barrinhas) o nav_controller
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);

        //Configura a navegação no menu ( se vc não configurar, não da pra clicar nos menus internos)
        NavigationUI.setupWithNavController(navigationView, navController);
    }
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

     */

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
