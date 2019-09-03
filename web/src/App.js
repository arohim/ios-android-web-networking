import React from 'react';
import logo from './logo.svg';
import './App.css';
import SharedCode from 'SharedCode'

const sharedCode = SharedCode.com.jetbrains.handson.mpp.mobile;
const weatherApi = SharedCode.com.jetbrains.handson.mpp.mobile.WeatherApi()
const weatherRepo = SharedCode.com.jetbrains.handson.mpp.mobile.WeatherRepositoryImpl(weatherApi);

function App() {

  function callAPI() {
    console.log("call API")
    var sharedCode = SharedCode
    console.log("platform name " + sharedCode.com.jetbrains.handson.mpp.mobile.platformName())
  }

  return (
    <div className="App">
      <header className="App-header">
        Kotlin Rocks on {sharedCode.platformName()}
      </header>
    </div>
  );
}

const buttonStyle = {
  width: 500,
  height: 80,
  fontSize: 20
};

export default App;
