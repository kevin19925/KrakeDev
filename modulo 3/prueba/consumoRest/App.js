import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';
import { NavigationContainer } from '@react-navigation/native'
import {createNativeStackNavigator} from '@react-navigation/native-stack'
import {ProductForm} from './screens/ProductForm'
import {ProductList} from './screens/ProductList'
export default function App() {
  const StackProducts = createNativeStackNavigator(); 
  return (
    <NavigationContainer>
      <StackProducts.Navigator>
        <StackProducts.Screen name="ProductFormNav"  component={ProductForm}/>
        <StackProducts.Screen name="ProductListNav" component={ProductList}/>
      </StackProducts.Navigator>
    </NavigationContainer>
  );
}
