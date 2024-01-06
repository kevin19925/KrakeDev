import { StyleSheet, Text, View } from "react-native";
import { Button, Icon } from "@rneui/base";
import { Input } from "@rneui/themed";
import { useState } from "react";
import { saveNotas, updatenota } from "../services/gradeService";
export const GradeForm = ({ navigation, route }) => {
  let isNew = true;
  let matR;
  let notR;
  if (route.params.notita != null) {
    isNew = false;
  }
  if (route.params.notita == null) {
    isNew = true;
  }
  console.log(route.params.notita);

  if (!isNew) {
    matR = route.params.notita.materia;
    notR = route.params.notita.nota;
  }
  const [materia, setmateria] = useState(matR);
  const [nota, setnota] = useState(notR == null ? null : notR + "");
  const [errorMateria, setErrorMateria] = useState();
  const [errorNOta, setErrorNota] = useState();
  let hasError = false;

  const save = () => {
    setErrorMateria(null);
    setErrorNota(null);

    validar();
    if (!hasError) {
      if (isNew) {
        saveNotas({ materia: materia, nota: nota });
      } else {
        updatenota({ materia: materia, nota: nota });
      }
      navigation.goBack();
      route.params.fnRefresh();
    }
  };
  const validar = () => {
    if (materia == null || materia == "") {
      setErrorMateria("debe ingresar materia");
      hasError = true;
    }
    let notaFloat = parseFloat(nota);
    if (
      notaFloat == null ||
      isNaN(notaFloat) ||
      nota == null ||
      notaFloat < 0 ||
      notaFloat > 10
    ) {
      setErrorNota("debe ingresar nota entre 0-10");
      hasError = true;
    }
  };
  return (
    <View style={styles.container}>
      <Input
        value={materia}
        onChangeText={setmateria}
        placeholder="ejemplo :matematicas"
        label="Materias"
        errorMessage={errorMateria}
        editable={isNew}
      ></Input>
      <Input
        value={nota}
        onChangeText={setnota}
        placeholder="0-10"
        label="Nota"
        errorMessage={errorNOta}
        keyboardType="numeric"
      ></Input>
      <Button
        title="guardar"
        icon={{ name: "save", type: "entypo", color: "white" }}
        buttonStyle={styles.saveButton}
        onPress={save}
      ></Button>
    </View>
  );
};
const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#fff",
    alignItems: "center",
    justifyContent: "center",
  },

  saveButton: {
    backgroundColor: "green",
  },
});
