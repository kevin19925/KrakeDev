import { StatusBar } from "expo-status-bar";
import { useState } from "react";
import { StyleSheet, Text, View, Button, TextInput } from "react-native";

export default function App() {
  [peso, setPeso] = useState("?");
  [estatura, setEstatura] = useState("?");
  [imc, setimc] = useState("0");
  [imcMensaje, setimcMensaje] = useState("?");

  calcularImc = () => {
    let estaturacm = parseFloat(estatura) / 100;
    let pesoKg = parseFloat(peso);
    setimc(pesoKg / (estaturacm * estaturacm));

    if (isNaN(peso) || isNaN(estatura)) {
      alert("ingrese datos correctos");
      setimcMensaje("?");
      setimc(0);
    }
    
      if (imc > 0 && imc < 18.5) {
        setimcMensaje("Peso inferior al normal");
      } else if (imc >= 18.5 && imc <= 24.9) {
        setimcMensaje("Normal");
      } else if (imc >= 25 && imc <= 29.9) {
        setimcMensaje("Peso superior al normal");
      } else if (imc >= 30) {
        setimcMensaje("Obesidad");
      }
    
  };
  return (
    <View style={styles.container}>
      <View style={styles.contenedor1}>
        <Text style={styles.titulo}>Calculadora IMC </Text>
      </View>

      <View style={styles.contenedor2}>
        <Text style={styles.txt}>ESTATURA</Text>
        <TextInput
          style={styles.caja}
          placeholder="estatura en cm"
          onChangeText={(txt) => {
            setEstatura(txt);
          }}
        ></TextInput>
        <Text style={styles.txt}> PESO</Text>
        <TextInput
          style={styles.caja}
          placeholder="peso en kg"
          onChangeText={(txt) => {
            setPeso(txt);
          }}
        ></TextInput>
        <Button title="Calcular" onPress={calcularImc}></Button>
        <Text style={styles.txt}>Resultado: {imc}</Text>
        <Text style={styles.resultado}>
          Composición corporal : {imcMensaje}
        </Text>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,

    flexDirection: "column",
  },

  contenedor1: {
    flex: 3,

    flexDirection: "column",
    justifyContent: "center",
    alignItems: "center",
  },

  contenedor2: {
    flex: 6,

    flexDirection: "column",
    justifyContent: "flex-start",
    alignItems: "center",
  },

  caja: {
    borderColor: "black",
    borderWidth: 1,
    width: 150,
    height: 40,
    padding: 10,
    marginVertical: 5,
  },
  txt: {
    color: "#9BE620",
    marginVertical: 5,
    fontSize: 18,
    fontWeight: "bold",
  },
  titulo: {
    marginVertical: 5,
    fontSize: 30,
    fontWeight: "bold",
    color: "#208CE6",
  },
  resultado: {
    marginVertical: 5,
    fontSize: 20,
    fontWeight: "bold",
    color: "#CD5AE7",
  },
});
