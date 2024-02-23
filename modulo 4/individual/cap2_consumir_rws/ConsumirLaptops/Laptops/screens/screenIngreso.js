import { Alert, StyleSheet, Text, View } from "react-native";
import { Button, ListItem } from "@rneui/base";
import { useState, useEffect } from "react";
import { saveRest, updateRest, deleteRest } from "../rest_Laptops/Laptops";
import { Input } from "@rneui/themed";

export const Ingreso = ({ navigation, route }) => {
  // en route el obj que se mando desde el otro form con el mimos nombre .
  let LapRetrieved = route.params.objLaptop;
  let isNew = true;
  if (LapRetrieved != null) {
    isNew = false;
  }

  const [marca, setMarca] = useState(isNew ? null : LapRetrieved.marca);
  const [procesador, setProcesador] = useState(
    isNew ? null : LapRetrieved.procesador
  );
  const [memoria, setMemoria] = useState(isNew ? null : LapRetrieved.memoria);
  const [id, setId] = useState(isNew ? null : LapRetrieved.id);
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
        id: LapRetrieved.id,
        marca: marca,
        procesador: procesador,
        memoria: memoria,
      },
      mostrarAlert
    );
  };

  const mostrarAlert = (mensaje) => {
    Alert.alert("Confirmacion", mensaje, [
      {
        text: "ok",
        onPress: () => {
          navigation.goBack();
        },
      },
    ]);
  };

  const confirLaptop = () => {
    Alert.alert("Confirmacion ", "esta seguro que quiere eliminar", [
      {
        text: "SI",
        onPress: deleteLaptop,
      },
      { text: "NO" },
    ]);
  };

  const deleteLaptop = () => {
    deleteRest({ id: LapRetrieved.id }, mostrarAlert);
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

      {isNew ? (
        <View></View>
      ) : (
        <Button title="ELIMINAR" onPress={confirLaptop}></Button>
      )}
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
