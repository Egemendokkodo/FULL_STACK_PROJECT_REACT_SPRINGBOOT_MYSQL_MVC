import LoginForm from "./Login_Page/loginform";
import {BrowserRouter as Router, Route, Routes} from "react-router-dom"
import SignUpPage from "./Sign_Up_Page/sign_up_page";



function App() {
  return (
    <Router>
      <Routes>
      <Route path="/" element={<LoginForm/>}/>
      <Route path="/login" element={<LoginForm/>}/>
      <Route path="/signUp" element={<SignUpPage/>}/>
      </Routes>
    </Router>

    //<LoginForm/>

    
  );
}

export default App;
