import { StatusBar } from "expo-status-bar";
import { StyleSheet, Text, View, Button } from "react-native";

export default function App() {
  return (
    <View style={styles.container1}>
      {/* <Text>Open up App.js to start working on your app!</Text>
      <StatusBar style="auto" />
      <Button title="com1"></Button>
      <Button title="com2" color="green"></Button>
      <Button title="com1"></Button> */}
      <View style={styles.container2}></View>
      <View style={styles.container3}>
        <View style={styles.container4}></View>
        <View style={styles.container5}>
          <View style={styles.container6}></View>
          <View style={styles.container7}>
            <Button title="com1"></Button>
            <Button title="com2" color="black"></Button>
            <Button title="com3"></Button>
          </View>
        </View>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container1: {
    flex: 1,
    backgroundColor: "gray",

    flexDirection: "colum",
    // justifyContent: "flex-end",
    // alignItems: "stretch",
  },

  container2: {
    flex: 1,
    backgroundColor: "blue",

    flexDirection: "colum",
    // justifyContent: "flex-end",
    // alignItems: "stretch",
  },
  container3: {
    flex: 3,
    backgroundColor: "green",

    flexDirection: "colum",
    // justifyContent: "flex-end",
    // alignItems: "stretch",
  },
  container4: {
    flex: 3,
    backgroundColor: "yellow",

    flexDirection: "row",
    // justifyContent: "flex-end",
    // alignItems: "stretch",
  },
  container5: {
    flex: 3,
    backgroundColor: "white",
    flexDirection: "row",
    // justifyContent: "flex-end",
    // alignItems: "stretch",
  },
  container6: {
    flex: 1,
    backgroundColor: "black",

    flexDirection: "colum",
    // justifyContent: "flex-end",
    // alignItems: "stretch",
  },
  container7: {
    flex: 2,
    backgroundColor: "green",

    flexDirection: "colum",
    justifyContent: "space-around",
    alignItems: "center",
    // justifyContent: "flex-end",
    // alignItems: "stretch",
  },
});
