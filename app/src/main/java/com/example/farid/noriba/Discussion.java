package com.example.farid.noriba;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.farid.noriba.model.Conversation;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Discussion extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference convReference;
    private List<Conversation> convList = new ArrayList<>();
    private ListView convListView;
    private ConvArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discussion);
        firebaseDatabase = FirebaseDatabase.getInstance();
        convReference = firebaseDatabase.getReference().child("conv");
        convListView = findViewById(R.id.convListView);
        //creation de la vue qui liste les livres
        adapter = new ConvArrayAdapter(this, R.layout.conv_list_item , convList);
        convListView.setAdapter(adapter);
        //recuperation des données avec abonnement au modif ulterieurs
        convReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //reinitialiser la list
                convList.clear();
                //boucler sur lensemble des noeuds
                for (DataSnapshot convSnap : dataSnapshot.getChildren()) {
                    //creation d'une instance darticle et hydratation avec les données du snapshot
                    Conversation conv = convSnap.getValue(Conversation.class);
                    //ajout du livre a la liste
                    convList.add(conv);
                }
                Log.d(" MAIN", "------------------- Fin de recuperation des données -----------------------");
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        Log.d("MAIN", "Fin de onCreate()");
        //addBooks();
    }

    private class ConvArrayAdapter extends ArrayAdapter<Conversation> {

        private Activity context;
        int resource;
        List<Conversation> data;

        public ConvArrayAdapter(@NonNull Activity context, int resource, @NonNull List<Conversation> data) {
            super(context, resource, data);
            this.context = context;
            this.resource = resource;
            this.data = data;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View view = context.getLayoutInflater().inflate(this.resource, parent, false);
            Conversation currentConv = convList.get(position);
            TextView textView = view.findViewById(R.id.convListText);
            textView.setText(currentConv.getUserF() + " par " + currentConv.getDateC()+ " et "+ currentConv.getMessages().getContent());
            return view;
        }
    }

    public void addForm(View view) {
        //Intent form = new Intent(this,AddBook.class);
       // startActivity(form);

        // TextView nom = findViewById(R.id.nom);
        // TextView prenom = findViewById(R.id.prenom);
        // TextView nationalite = findViewById(R.id.nationalite);
        // TextView prix = findViewById(R.id.prix);
        // TextView titre = findViewById(R.id.titre);
        // String formNom = nom.getText().toString();
        // String formPrenom = prenom.getText().toString();
        // String formNat = nationalite.getText().toString();
        // String formPrix = prix.getText().toString();
        // String formTitre = titre.getText().toString();

        // String bookId = bookReference.push().getKey();
        // Author auteur = new Author( formNom  , formPrenom, formNat);
        // Book book = new Book(formTitre, Double.parseDouble(formPrix), auteur);
        // bookReference.child((bookId)).setValue(book);

        // //creation d'un livre
        // String bookId1 = bookReference.push().getKey();
        // String bookId2 = bookReference.push().getKey();
        // String bookId3 = bookReference.push().getKey();
        // Author hugo = new Author("Hugo", "Victor", "Francais");
        // Author rachid = new Author("Arabe", "Rachid", "Francais");
        // Author ibnKhaldoun = new Author("Khaldoun", "Ibn", "Tunisiens");
        // Book book1 = new Book("Les Miserables", 25.0, hugo);
        // Book book2 = new Book("Les Journalistes Etrangers", 20.0, rachid);
        // Book book3 = new Book("Les civilisations", 45.0, ibnKhaldoun);
        // bookReference.child((bookId1)).setValue(book1);
        // bookReference.child((bookId2)).setValue(book2);
        // bookReference.child((bookId3)).setValue(book3);
    }
}
