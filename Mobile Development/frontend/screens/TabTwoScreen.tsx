import {ScrollView, StyleSheet} from 'react-native';

import { Text, View } from '../components/Themed';
import {useIsSignedIn} from "../hooks/useIsSignedIn";
import * as React from "react";
import {Book} from "../models/book";
import {getBook} from "../api/api";
import {useIsFocused} from "@react-navigation/native";

export default function TabTwoScreen() {
    const [isLoading, username] = useIsSignedIn();
    const [bookList, setBookList] = React.useState<Array<Book>>([]);
      const isFocused = useIsFocused();

  React.useEffect(()=>{
    if(username=="")
      return;
    if(!isFocused)
      return;
    getBook(username).then(response => {
      response.json().then(data=>setBookList(data))
    })
  }, [username,isFocused])
  return (isLoading ? <Text>Loading</Text> : username == "" ? <Text>You're not logged in!</Text> :
          <>
                  <Text style={styles.title}>Books page</Text>
    <ScrollView contentContainerStyle={styles.container}>
      {bookList.map((book, index) => <View key={index}>
        <Text>{book.title}</Text>
        <Text>{book.author}</Text>
        <Text>{book.rating}</Text>
        <Text>{book.short_review}</Text>
        <View style={styles.separator} lightColor="fae2e2" darkColor="rgba(255,255,255,0.1)" />

        </View>)}
    </ScrollView>
            </>
  );
};

const styles = StyleSheet.create({
  container: {
    alignItems: 'center',
    justifyContent: 'center',
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
