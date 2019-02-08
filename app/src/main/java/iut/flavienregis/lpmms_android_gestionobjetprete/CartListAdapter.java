package iut.flavienregis.lpmms_android_gestionobjetprete;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Parcelable;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.MyViewHolder> {
    private Context context;
    private List<Item> cartList;
    private Item item;
    GestionPretDAO bd;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, description, date, idItem;
        public ImageView thumbnail;
        public RelativeLayout viewBackground, viewForeground;
        public TextView buttonViewOption;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            description = view.findViewById(R.id.description);
            date = view.findViewById(R.id.date);
            thumbnail = view.findViewById(R.id.thumbnail);
            viewBackground = view.findViewById(R.id.view_background);
            viewForeground = view.findViewById(R.id.view_foreground);
            buttonViewOption = view.findViewById(R.id.textViewOptions);
            idItem = view.findViewById(R.id.idItem);
        }

    }


    public CartListAdapter(Context context, List<Item> cartList) {
        this.context = context;
        this.cartList = cartList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.casier_liste, parent, false);

        bd = GestionPretDAO.getInstanceDAO(context);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        item = cartList.get(position);
        holder.name.setText(item.getDesignation());
        holder.description.setText(item.getDescription());
        holder.date.setText(item.getDate());
        holder.thumbnail.setImageBitmap(BitmapFactory.decodeByteArray(item.getThumbnail(), 0, item.getThumbnail().length));
        Log.println(Log.DEBUG, "ID", item.getId()+"");
        holder.idItem.setText(item.getId()+"");

        Glide.with(context)
                    .load(item.getThumbnail())
                    .into(holder.thumbnail);

        holder.buttonViewOption.setOnClickListener(new View.OnClickListener() {
                @Override
            public void onClick(View view) {
                //création du popup menu
                PopupMenu popup = new PopupMenu(context, holder.buttonViewOption);
                //inflate menu depuis les ressources xml
                popup.inflate(R.menu.menu_contextuel);
                //ajout click listener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.visualiser_pret:
                                Intent intention = new Intent(context, VisuEmprunt.class);
                                intention.putExtra("item", holder.idItem.getText().toString());
                                context.startActivity(intention);
                                break;
                            case R.id.modifier_pret:
                                Intent intention2 = new Intent(context, ModifEmprunt.class);
                                intention2.putExtra("item", holder.idItem.getText().toString());
                                context.startActivity(intention2);
                                break;
                            case R.id.annuler:
                                break;
                        }
                        return false;
                    }
                });
                //affichage de la popup
                popup.show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    public void removeItem(int position) {
        cartList.remove(position);
        notifyItemRemoved(position);
        bd.deletePret(item.getId());
    }

    public void restoreItem(Item item, int position) {
        cartList.add(position, item);
        notifyItemInserted(position);
        bd.createPret(item.getDesignation(), item.getDescription(), null, item.getNom(), item.getPrenom(), item.getCommentaire());
    }

    public void addItem(Item item) {
        cartList.add(item);
        notifyItemInserted(cartList.size() - 1 );
    }
}
