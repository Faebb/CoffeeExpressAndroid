package com.example.coffeeexpressandroid;

import java.util.List;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.view.Menu;
import android.graphics.Color;
import android.widget.ImageButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.example.coffeeexpressandroid.api.apiservices;
import com.example.coffeeexpressandroid.api.model.Coffee; // Modelo de datos
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import androidx.appcompat.widget.Toolbar;
import com.example.coffeeexpressandroid.databinding.ActivityMainBinding;
import com.bumptech.glide.Glide;
import com.example.coffeeexpressandroid.api.model.ResponseData;// Importando Glide para cargar imágenes

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private Retrofit retrofit;
    private apiservices apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Configurando Retrofit
        retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:5235/api/coffees/") // URL base para el emulador
                .addConverterFactory(GsonConverterFactory.create())  // Conversor Gson
                .build();
        apiService = retrofit.create(apiservices.class);  // Interfaz de servicios API

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .setAnchorView(R.id.fab).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_capsule)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupWithNavController(navigationView, navController);

        // Establecer el título manualmente
        getSupportActionBar().setTitle("CoffeeExpress");

        // Cambiar el color del texto del título
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.parseColor("#1A120B"));

        // Configurar el botón para abrir el menú
        ImageButton menuButton = findViewById(R.id.button2);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(navigationView);
            }
        });

        // Llamada API para obtener datos
        getDataFromApi();
    }

    // Método para hacer la solicitud a la API
    private void getDataFromApi() {
        Call<List<Coffee>> call = apiService.getCoffees();  // Cambié ResponseData por List<Coffee>

        call.enqueue(new Callback<List<Coffee>>() {
            @Override
            public void onResponse(Call<List<Coffee>> call, Response<List<Coffee>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Coffee> coffeeList = response.body();

                    if (coffeeList != null && !coffeeList.isEmpty()) {
                        Toast.makeText(MainActivity.this, "Datos recibidos", Toast.LENGTH_SHORT).show();

                        for (int i = 0; i < coffeeList.size() && i < 2; i++) {
                            Coffee coffee = coffeeList.get(i);

                            String imageUrl = coffee.getUrl();
                            String productName = coffee.getName();
                            String productPrice = String.valueOf(coffee.getPrice());

                            // Obtener referencias de vista
                            int imageId = getResources().getIdentifier("image_" + (i + 1), "id", getPackageName());
                            int nameId = getResources().getIdentifier("product_name_" + (i + 1), "id", getPackageName());
                            int priceId = getResources().getIdentifier("product_price_" + (i + 1), "id", getPackageName());

                            ImageView imageView = findViewById(imageId);
                            TextView nameView = findViewById(nameId);
                            TextView priceView = findViewById(priceId);

                            // Cargar imagen y textos
                            Glide.with(MainActivity.this)
                                    .load(imageUrl)  // opcional
                                    .into(imageView);

                            nameView.setText(productName);
                            priceView.setText("$ " + productPrice);
                        }
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Error en la respuesta: " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Coffee>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error en la solicitud: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
