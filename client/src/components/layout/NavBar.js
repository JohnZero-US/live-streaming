import React, { Fragment } from "react";
import { Link } from "react-router-dom";
import { connect } from "react-redux";
import PropTypes from "prop-types";

const NavBar = () => {
  return (
    <nav className="navbar bg-primary">
      <h1>
        <Link to="/">
          <i className="fas fa-code" /> Live Streaming
        </Link>
      </h1>
    </nav>
  );
};
//
//NavBar.PropTypes = {};

//
const mapStateToProps = state => ({});

//
export default connect(mapStateToProps)(NavBar);
