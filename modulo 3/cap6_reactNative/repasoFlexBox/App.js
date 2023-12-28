import { StatusBar } from "expo-status-bar";
import { StyleSheet, Text, View, Button } from "react-native";

export default function App() {
  return (
    <View style={styles.container1}>
      <View style={styles.container2}>
        <Button title="x"></Button>
        <Button title="y"></Button>
        <Button title="z"></Button>
      </View>
      <View style={styles.container3}>
        <View style={styles.container5}>
          <View style={styles.container7}>
            <Button title="com1"></Button>
            <Button title="com2"></Button>
          </View>
          <View style={styles.container8}>
            <Button title="operacion 1"></Button>
            <Button title="operacion 2"></Button>
            <Button title="operacion 3"></Button>
          </View>
        </View>
        <View style={styles.container6}>
          <Button title="accion1"></Button>
          <Button title="accion2"></Button>
        </View>
      </View>
      <View style={styles.container4}>
        <Button title="BOTON FINAL"></Button>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container1: {
    flex: 1,
    backgroundColor: "blue",
    flexDirection: "colum",
  },
  container2: {
    flex: 1,
    backgroundColor: "#0FAFAF",
    flexDirection: "row",
    justifyContent: "flex-end",
    alignItems: "center",
  },
  container3: {
    flex: 6,
    backgroundColor: "green",
    flexDirection: "colum",
    justifyContent: "flex-end",
    alignItems: "stretch",
  },
  container4: {
    flex: 1,
    backgroundColor: "#F8A43F",
    flexDirection: "row",
    justifyContent: "flex-start",
    alignItems: "center",
  },
  container5: {
    flex: 4,
    backgroundColor: "white",
    flexDirection: "row",
    justifyContent: "flex-end",
    alignItems: "stretch",
  },
  container6: {
    flex: 1,
    backgroundColor: "blue",
    flexDirection: "row",
    justifyContent: "center",
    alignItems: "flex-end",
  },
  container7: {
    flex: 1,
    backgroundColor: "yellow",
    flexDirection: "colum",
    justifyContent: "space-around",
    alignItems: "stretch",
  },
  container8: {
    flex: 1,
    backgroundColor: "white",
    flexDirection: "colum",
    justifyContent: "center",
    alignItems: "flex-start",
  },
});
