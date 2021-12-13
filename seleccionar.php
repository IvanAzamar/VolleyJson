<?php
$cont=0;
$c=mysqli_connect("localhost","root","","webservices");
$r=mysqli_query($c,"SELECT * FROM mapa");

while($fila=$r->fetch_array()){
    $ubicaciones[]= array_map('utf8_encode',$fila);
}
echo json_encode($ubicaciones);

?>