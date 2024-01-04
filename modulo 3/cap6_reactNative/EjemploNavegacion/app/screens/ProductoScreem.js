import { StyleSheet, Text, View, Button } from "react-native";

export const Producto = ({ navigation }) => {
  return (
    <View style={styles.container}>
      <Text>estoy en productos</Text>
      <Button
        title="ir a home"
        onPress={() => {
          navigation.navigate("HomeNav");
        }}
      ></Button>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,

    flexDirection: "column",
    justifyContent: "center",
    alignItems: "center",
  },
});
