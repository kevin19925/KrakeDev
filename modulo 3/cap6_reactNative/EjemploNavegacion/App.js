import { StyleSheet, Text, View, Button } from "react-native";

import * as React from "react";

import { NavigationContainer } from "@react-navigation/native";
import { createNativeStackNavigator } from "@react-navigation/native-stack";

import { Home } from "./app/screens/HomeScreem";
import { Contats } from "./app/screens/ContactScreem";
import { Producto } from "./app/screens/ProductoScreem";

// componente
const Stack = createNativeStackNavigator();






export default function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="HomeNav" component={Home}></Stack.Screen>
        <Stack.Screen name="ContactNav" component={Contats}></Stack.Screen>
        <Stack.Screen name="ProductoNav" component={Producto}></Stack.Screen>
      </Stack.Navigator>
    </NavigationContainer>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#fff",
    alignItems: "center",
    justifyContent: "center",
  },
});
