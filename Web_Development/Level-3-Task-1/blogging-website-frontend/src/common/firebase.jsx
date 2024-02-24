// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
import { GoogleAuthProvider, getAuth, signInWithPopup } from "firebase/auth";

const firebaseConfig = {
  apiKey: "AIzaSyCfw2GhbRjm-5_Cf__qxWzq6mT9m8fXeTM",
  authDomain: "reactjs-blogging-website-632a9.firebaseapp.com",
  projectId: "reactjs-blogging-website-632a9",
  storageBucket: "reactjs-blogging-website-632a9.appspot.com",
  messagingSenderId: "856783778632",
  appId: "1:856783778632:web:346a6ec074518cff1ef97d",
  measurementId: "G-DEKPX2R3ND",
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
// const analytics = getAnalytics(app);

//google auth
const provider = new GoogleAuthProvider();
const auth = getAuth();

export const authWithGoogle = async () => {
  let user = null;

  await signInWithPopup(auth, provider)
    .then((result) => {
      user = result.user;
    })
    .catch((err) => {
      console.log(err);
    });

  return user;
};
