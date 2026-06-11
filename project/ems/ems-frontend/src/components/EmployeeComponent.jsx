import React, { useEffect, useState } from 'react'
import { createEmployee, getEmployee, updateEmployee } from '../services/EmployeeService'
import { useNavigate, useParams } from 'react-router-dom'
import toast from 'react-hot-toast'
import { Save, X, User } from 'lucide-react'

const EmployeeComponent = () => {

    const [firstName, setFirstName] = useState('')
    const [lastName, setLastName] = useState('')
    const [email, setEmail] = useState('')

    const { id } = useParams();

    const [errors, setErrors] = useState({
        firstName: '',
        lastName: '',
        email: ''
    })

    const navigator = useNavigate();

    useEffect(() => {
        if (id) {
            getEmployee(id).then((response) => {
                setFirstName(response.data.firstName);
                setLastName(response.data.lastName);
                setEmail(response.data.email);
            }).catch(error => {
                console.error(error);
                toast.error("Error fetching employee details");
            })
        }
    }, [id])

    function saveOrUpdateEmployee(e) {
        e.preventDefault();

        if (validateForm()) {
            const employee = { firstName, lastName, email }

            if (id) {
                updateEmployee(id, employee).then((response) => {
                    toast.success("Employee updated successfully");
                    navigator('/employees');
                }).catch(error => {
                    console.error(error);
                    toast.error("Update failed");
                })
            } else {
                createEmployee(employee).then((response) => {
                    toast.success("Employee added successfully");
                    navigator('/employees')
                }).catch(error => {
                    console.error(error);
                    toast.error("Save failed");
                })
            }
        }
    }

    function validateForm() {
        let valid = true;
        const errorsCopy = { ...errors }

        if (firstName.trim()) {
            errorsCopy.firstName = '';
        } else {
            errorsCopy.firstName = 'First name is required';
            valid = false;
        }

        if (lastName.trim()) {
            errorsCopy.lastName = '';
        } else {
            errorsCopy.lastName = 'Last name is required';
            valid = false;
        }

        if (email.trim()) {
            errorsCopy.email = '';
        } else {
            errorsCopy.email = 'Email is required';
            valid = false;
        }

        setErrors(errorsCopy);
        return valid;
    }

    function pageTitle() {
        if (id) {
            return <h2 className='text-primary fw-bold mb-4'>Update Employee</h2>
        } else {
            return <h2 className='text-primary fw-bold mb-4'>Add Employee</h2>
        }
    }

    return (
        <div className='container py-5'>
            <div className='row justify-content-center'>
                <div className='col-md-8 col-lg-6'>
                    <div className='card border-0 p-4'>
                        {pageTitle()}
                        <form>
                            <div className='form-group mb-4'>
                                <label className='form-label fw-semibold text-secondary'>First Name</label>
                                <input
                                    type='text'
                                    placeholder='Enter Employee First Name'
                                    name='firstName'
                                    value={firstName}
                                    className={`form-control ${errors.firstName ? 'is-invalid' : ''}`}
                                    onChange={(e) => setFirstName(e.target.value)}
                                />
                                {errors.firstName && <div className='invalid-feedback'>{errors.firstName}</div>}
                            </div>

                            <div className='form-group mb-4'>
                                <label className='form-label fw-semibold text-secondary'>Last Name</label>
                                <input
                                    type='text'
                                    placeholder='Enter Employee Last Name'
                                    name='lastName'
                                    value={lastName}
                                    className={`form-control ${errors.lastName ? 'is-invalid' : ''}`}
                                    onChange={(e) => setLastName(e.target.value)}
                                />
                                {errors.lastName && <div className='invalid-feedback'>{errors.lastName}</div>}
                            </div>

                            <div className='form-group mb-4'>
                                <label className='form-label fw-semibold text-secondary'>Email</label>
                                <input
                                    type='email'
                                    placeholder='Enter Employee Email'
                                    name='email'
                                    value={email}
                                    className={`form-control ${errors.email ? 'is-invalid' : ''}`}
                                    onChange={(e) => setEmail(e.target.value)}
                                />
                                {errors.email && <div className='invalid-feedback'>{errors.email}</div>}
                            </div>

                            <div className="d-flex gap-3 pt-3">
                                <button className='btn btn-primary d-flex align-items-center gap-2 px-4 flex-grow-1 justify-content-center' onClick={saveOrUpdateEmployee}>
                                    <Save size={18} /> {id ? 'Update' : 'Submit'}
                                </button>
                                <button className='btn btn-light d-flex align-items-center gap-2 px-4 shadow-sm' onClick={() => navigator('/employees')}>
                                    <X size={18} /> Cancel
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default EmployeeComponent
