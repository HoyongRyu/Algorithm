import React, {Component} from 'react';
import { Modal, Alert } from 'react-bootstrap';

export default class ErrorPopup extends Component {
  render() {
    return (
      <Modal show={this.props.show} onHide={this.props.close}>
	    <Modal.Header closeButton>
	      <Modal.Title>
	        <span className="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>&nbsp;
	        Error
	      </Modal.Title>
	    </Modal.Header>
	    <Modal.Body>
	      <div className="alert alert-warning" role="warning">
	        {this.props.message}
	      </div>
	      <button className="btn btn-default" onClick={this.props.close}>Close</button>
	    </Modal.Body>
	  </Modal>
    );
  }
}
