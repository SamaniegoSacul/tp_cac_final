package interfaces;

import java.util.List;
import model.Mascotas;

public interface Crud {

    public List<Mascotas> listarMascotas();

    public Mascotas verMascota(int id);

    public Boolean agregar(Mascotas mascotas);

    public Boolean editar(Mascotas mascotas);

    public Boolean borrar(int id);

}
