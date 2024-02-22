import { Alert, StyleSheet, Text, View } from "react-native";
import { Button, ListItem } from "@rneui/base";
import { useState } from "react";
import { saveRest, updateRest } from "../rest_Laptops/Laptops";
import { Input } from "@rneui/themed";

export const Ingreso = ({ navigation, route }) => {
  // en route el obj que se mando desde el otro form con el mimos nombre .
  let contactRetrieved = route.params.objLaptop;
  let isNew = true;
  if (contactRetrieved != null) {
    isNew = false;
  }

  const [marca, setMarca] = useState(isNew ? null : contactRetrieved.marca);
  const [procesador, setProcesador] = useState(
    isNew ? null : contactRetrieved.procesador
  );
  const [memoria, setMemoria] = useState(
    isNew ? null : contactRetrieved.memoria
  );
  const [id, setId] = useState(isNew ? null : contactRetrieved.id);
  // resuperando
  console.log(route.params.objLaptop);

  const crear = () => {
    saveRest(
      { marca: marca, procesador: procesador, memoria: memoria },
      mostrarAlert
    );
  };
  const actualizar = () => {
    updateRest(
      {
        id: contactRetrieved.id,
        marca: marca,
        procesador: procesador,
        memoria: memoria,
      },
      mostrarAlert
    );
  };

  const mostrarAlert = () => {
    Alert.alert(
      "Título del Alerta",
      isNew ? "ingreso correcto" : "se edito correctamente",
      [
        {
          text: "OK",
          onPress: () => {
            console.log("OK Presionado");
            navigation.goBack();
          },
        },
        {
          text: "Cancelar",
          onPress: () => console.log("Cancelar Presionado"),
          style: "cancel", // Estilo de botón de cancelar
        },
      ],
      { cancelable: false }
    );
  };

  return (
    <View style={styles.container}>
      <Input
        placeholder="marca:"
        value={marca}
        onChangeText={(text) => {
          setMarca(text);
        }}
      ></Input>
      <Input
        placeholder="procesador: "
        value={procesador}
        onChangeText={(text) => {
          setProcesador(text);
        }}
      ></Input>
      <Input
        placeholder="memoria:"
        value={memoria}
        onChangeText={(text) => {
          setMemoria(text);
        }}
      ></Input>
      <Button title="GUARDAR" onPress={isNew ? crear : actualizar}></Button>
    </View>
  );
};
const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#fff",
    flexDirection: "column", // eje pricipal es vertical
    justifyContent: "center",
    alignItems: "stretch", // orisontal
  },
});
