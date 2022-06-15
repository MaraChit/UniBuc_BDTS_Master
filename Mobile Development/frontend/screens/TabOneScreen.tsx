import {Button, StyleSheet, TextInput} from 'react-native';

import { Text, View } from '../components/Themed';
import { RootTabScreenProps } from '../types';
import {useIsSignedIn} from "../hooks/useIsSignedIn";
import * as React from "react";
import {Book} from "../models/book";
import {User} from "../models/user";
import {createBook, createUser} from "../api/api";
import NumericInput from 'react-native-numeric-input'
import {useIsFocused} from "@react-navigation/native";
import AsyncStorage from "@react-native-async-storage/async-storage";

export default function TabOneScreen({ navigation }: RootTabScreenProps<'TabOne'>) {
  const addBook = (book: Book, username: string) : void =>{
    createBook(book, username);
    setBook({title: "", author: "", short_review: "", rating: 0})
  }


  const [isLoading, username] = useIsSignedIn();
  const [tempUsername, setTempUsername] = React.useState("")
    const getData = async () => {
        try {
            const value = await AsyncStorage.getItem('username')
            setTempUsername(value ? value: "")
            return value !== null;
        }
        catch(e) {
        }
    }
  const isFocused = useIsFocused();
  React.useEffect(()=>{
      getData()
  }, [isFocused])
  const [book, setBook] = React.useState<Book>({title: "", author: "", short_review: "", rating: 0})
  return (isLoading ? <Text>Loading</Text> : username == "" && tempUsername == "" ? <Text>You're not logged in!</Text> :
    <View style={styles.container}>
      <Text style={styles.title}>Add Book</Text>
      <Text style={styles.top}>Title</Text>
         <TextInput
          style={styles.input}
          value={book.title.toString()}
          onChangeText={(name: string) => setBook({...book, title: name})}
          placeholder={"title"}
        />
        <Text>Author</Text>
         <TextInput
          style={styles.input}
          value={book.author.toString()}
          onChangeText={(name: string) => setBook({...book, author: name})}
          placeholder={"author"}
        />
        <Text>Rating</Text>
         <NumericInput value={book.rating} onChange={value => setBook({...book, rating: value})}  textColor={"#000"}
 />

      <Text>Short review</Text>
         <TextInput
          style={styles.input}
          value={book.short_review.toString()}
          onChangeText={(review: string) => setBook({...book, short_review: review})}
          placeholder={"short review"}

        />
        <Button title={"submit"} onPress={()=>addBook(book, username != "" ? username : tempUsername)}/>
      <View style={styles.separator} lightColor="#eee" darkColor="rgba(255,255,255,0.1)" />

    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  top: {
      marginTop: 55,
    },
  input: {
    height: 50,
    width:150,
    backgroundColor: "#fff",
  },
  title: {
    fontSize: 20,
    fontWeight: 'bold',
  },
  separator: {
    marginVertical: 30,
    height: 1,
    width: '80%',
  },
});
