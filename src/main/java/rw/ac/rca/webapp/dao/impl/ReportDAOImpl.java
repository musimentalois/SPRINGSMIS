package rw.ac.rca.webapp.dao.impl;

import rw.ac.rca.webapp.dao.ReportDAO;

import rw.ac.rca.webapp.orm.Report;

import java.util.List;


public class ReportDAOImpl extends DAO implements ReportDAO {

    private static ReportDAOImpl instance;

    private ReportDAOImpl() {

    }

    public static ReportDAOImpl getInstance() {
        if (instance == null) {
            return new ReportDAOImpl();
        } else {
            return instance;
        }
    }

    @Override
    public List<Report> getAllReports() {
        return null;
    }

}