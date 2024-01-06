import { StatusBar } from "expo-status-bar";
import { StyleSheet, Text, View } from "react-native";
import { NavigationContainer } from "@react-navigation/native";
import { createNativeStackNavigator } from "@react-navigation/native-stack";
import { GradeForm } from "./app/screens/GradeForm";
import { ListGradeForm } from "./app/screens/ListGradeForm";

export default function App() {
  const StackGrade = createNativeStackNavigator();
  return (
    <NavigationContainer>
      <StackGrade.Navigator>
        <StackGrade.Screen name="ListFormeNAV" component={ListGradeForm} />
        <StackGrade.Screen name="GradeFormNav" component={GradeForm} />
      </StackGrade.Navigator>
    </NavigationContainer>
  );
}
