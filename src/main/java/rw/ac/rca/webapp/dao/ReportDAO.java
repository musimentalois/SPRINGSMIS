package rw.ac.rca.webapp.dao;

import rw.ac.rca.webapp.orm.Report;

import java.util.List;

public interface ReportDAO {

    public List<Report> getAllReports();
}