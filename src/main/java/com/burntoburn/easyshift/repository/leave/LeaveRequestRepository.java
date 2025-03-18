package com.burntoburn.easyshift.repository.leave;

import com.burntoburn.easyshift.entity.leave.ApprovalStatus;
import com.burntoburn.easyshift.entity.leave.LeaveRequest;
import com.burntoburn.easyshift.entity.schedule.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {

    // 특정 userId 의 모든 휴뮤일 조회
    @Query("SELECT lr FROM LeaveRequest lr WHERE lr.user.id = :userId")
    List<LeaveRequest> findAllByUserId(Long userId);

    @Query("SELECT lr FROM LeaveRequest lr " +
            "JOIN lr.schedule s " +
            "WHERE s.scheduleMonth = :scheduleMonth")
    List<LeaveRequest> findAllByScheduleMonth(YearMonth scheduleMonth);

    List<LeaveRequest> findByScheduleId(Long scheduleId);

    @Query("SELECT lr FROM LeaveRequest lr JOIN FETCH lr.user " +
            "WHERE lr.schedule = :schedule AND lr.approvalStatus = :approvalStatus")
    List<LeaveRequest> findAllByScheduleAndApprovalStatus(@Param("schedule") Schedule schedule, @Param("approvalStatus") ApprovalStatus approvalStatus);

    boolean existsByUserIdAndScheduleIdAndDate(Long userId, Long scheduleId, LocalDate date);
}
