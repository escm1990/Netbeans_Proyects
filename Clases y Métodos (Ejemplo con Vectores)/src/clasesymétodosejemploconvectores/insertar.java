package clasesymétodosejemploconvectores;
public class insertar extends agregar
{
public void cambiartamaño()
{
for(int i=0;i<=esp-1;i++)
{
if(dato<=vector[i])
{
pos=i;
break;
}
}
}
public void agregarvalor()
{
for(int i=valor;i>=pos;i--)
{
vector[i]=vector[i-1];
}
vector[pos]=dato;
}
}