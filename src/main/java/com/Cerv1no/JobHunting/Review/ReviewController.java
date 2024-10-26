package com.Cerv1no.JobHunting.Review;

import com.Cerv1no.JobHunting.Company.Company;
import com.Cerv1no.JobHunting.Company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController (ReviewService reviewService, CompanyService companyService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId) {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Review review) {
        if (reviewService.addReview(companyId, review))
            return new ResponseEntity<>("review added successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/reviews/{reviewId}")
    public  ResponseEntity<Review> getReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        return new ResponseEntity<>(reviewService.getReview(companyId, reviewId), HttpStatus.OK);
    }

    @PutMapping("/reviews/{reviewId}")
    public  ResponseEntity<String> updateReview(@PathVariable Long companyId, @PathVariable Long reviewId,
                                                @RequestBody Review review) {
        if (reviewService.updateReview(companyId, reviewId, review))
            return new ResponseEntity<>("Review successfully updated", HttpStatus.OK);
        else
            return new ResponseEntity<>("Review not successfully updated", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        if (reviewService.deleteReview(companyId, reviewId))
            return new ResponseEntity<>("Review successfully deleted", HttpStatus.OK);
        else
            return new ResponseEntity<>("Review not successfully deleted", HttpStatus.NOT_FOUND);
    }
}
