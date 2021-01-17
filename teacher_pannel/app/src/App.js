import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";
import { CookiesProvider } from "react-cookie";

import logo from './logo.svg';
import './App.css';
import TopBar from './components/TopBar';

import LoginPage from "./Pages/LoginPage";
import HomePage from "./Pages/HomePage";

function App() {
  return (
    <CookiesProvider>
      <Router>
        <Switch>
          <Route exact path="/login">
            <LoginPage />
          </Route>
          <Route path="/">
            <HomePage />
          </Route>
        </Switch>
      </Router>
    </CookiesProvider>
  );
}

export default App;
