#ifndef DETECTFACIALFEATURES_H
#define DETECTFACIALFEATURES_H
#include <opencv2/objdetect/objdetect.hpp>
#include <opencv2/highgui/highgui.hpp>
#include <opencv2/imgproc/imgproc.hpp>

#include <opencv2/core/core.hpp>
#include <opencv2/ml/ml.hpp>
#include <math.h>
#include <stdio.h>
#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>
#include <fstream>

using namespace std;
using namespace cv;
using namespace ml;


void help();
void detectFaces(Mat&, vector<Rect_<int> >&, string);
void detectEyes(Mat&, vector<Rect_<int> >&, string);
void detectNose(Mat&, vector<Rect_<int> >&, string);
void detectMouth(Mat&, vector<Rect_<int> >&, string);
void detectFacialFeaures(Mat&, const vector<Rect_<int> >, string, string, string);

class DetectFacialFeatures
{

public:
	DetectFacialFeatures()
	{

	}

	void detectFaces(Mat& img, vector<Rect_<int> >& faces, string cascade_path)
	{
		CascadeClassifier face_cascade;
		face_cascade.load(cascade_path);
		if (img.data)
			face_cascade.detectMultiScale(img, faces, 1.15, 3, 0 | CASCADE_SCALE_IMAGE, Size(120, 120));
		return;
	}



	void detectFacialFeatures(Mat& img, const vector<Rect_<int> > faces, string eye_cascade, string nose_cascade, string mouth_cascade, string label)
	{
		Point le, re, me, no, mo, fh;//centroids of landmarks
		Point eye_point[3];
		Rect e, n, m;
		Mat ROI;
		Mat Face;
		for (unsigned int i = 0; i < faces.size(); ++i)
		{
			// Mark the bounding box enclosing the face
			Rect face = faces[i];
			rectangle(img, Point(face.x, face.y), Point(face.x + face.width, face.y + face.height), Scalar(255, 0, 0), 1, 4);

			// Eyes, nose and mouth will be detected inside the face (region of interest)
			if (img.data)
				if (face.x >= 0 && face.y >= 0 && face.width + face.x >= ROI.cols && face.height + face.y >= ROI.rows)
					ROI = img(Rect(face.x, face.y, face.width, face.height));
			if (img.data)
				if (ROI.data && face.x >= 0 && face.y >= 0 && face.width + face.x >= ROI.cols && face.height + face.y >= ROI.rows)
					Face = img(Rect(face.x * 1.75, face.y * 1.2, face.width * 0.75, face.height * 0.825));
			if (Face.data){
				resize(Face, Face, Size(120, 120), 0, 0, INTER_CUBIC);
				imwrite(".\\Faces\\" + label + ".JPG", ROI);
			}
			// Check if all features (eyes, nose and mouth) are being detected
			bool is_full_detection = false;
			if ((!eye_cascade.empty()) && (!nose_cascade.empty()) && (!mouth_cascade.empty()))
				is_full_detection = true;

			// Detect eyes if classifier provided by the user
			if (!eye_cascade.empty())
			{
				Mat eye;
				Mat cheek;
				vector<Rect_<int> > eyes;
				if (ROI.data && face.x >= 0 && face.y >= 0 && face.width + face.x >= ROI.cols && face.height + face.y >= ROI.rows)//Just ensure we are not cropping a larger portion than ROI face
					detectEyes(ROI, eyes, eye_cascade);

				// Mark points corresponding to the centre of the eyes
				unsigned int j;
				for (j = 0; j < eyes.size(); ++j)
				{
					e = eyes[j];
					//circle(ROI, Point(e.x + e.width / 2, e.y + e.height / 2), 3, Scalar(0, 255, 0), -1, 8);//Draw circle at center of eyes
					//cout << "Eye at (" << Point(e.x + e.width / 2, e.y + e.height / 2) << ")" << endl;
					//Draw rectangle around the eyeseye
					if (j == 0)
						//rectangle(ROI, Point(e.x * 1.1, e.y), Point((e.x + e.width), (e.y + e.height)), Scalar(255, 255, 255), 1, 4);
						////Trying to crop the eyes and save them
						cout << "";
					//else
					//rectangle(ROI, Point(e.x * 1.05, e.y), Point((e.x + e.width), (e.y + e.height)), Scalar(255, 255, 255), 1, 4);
					//Crop eyes
					if (j == 0)
						if (ROI.data && face.x >= 0 && face.y >= 0 && face.width + face.x >= ROI.cols && face.height + face.y >= ROI.rows)
							eye = ROI(Rect(e.x * 1.1, e.y, (e.width), (e.height)));
						else
							if (ROI.data && face.x >= 0 && face.y >= 0 && face.width + face.x >= ROI.cols && face.height + face.y >= ROI.rows)
								eye = ROI(Rect(e.x * 1.05, e.y, (e.width), (e.height)));
					if (eye.data)
					{
						resize(eye, eye, Size(42, 42));
						imwrite(".\\Eyes\\" + label + ".JPG", eye);
					}
					eye_point[j] = Point(e.x + e.width / 2, e.y + e.height / 2);
					//Draw rectangle around cheek born
					//if (j == 0)
					//	rectangle(ROI, Point(e.x * 1.1, e.y + e.height), Point((e.x + e.width), (e.y + 1.75 * e.height)), Scalar(0, 255, 0), 1, 4);
					//else
					//	rectangle(ROI, Point(e.x * 1.05, e.y + e.height), Point((e.x + e.width), (e.y + 1.75 * e.height)), Scalar(0, 255, 0), 1, 4);
					////Crop and save cheeks
					if (j == 0){
						if (ROI.data && face.x >= 0 && face.y >= 0 && face.width + face.x >= ROI.cols && face.height + face.y >= ROI.rows)
							cheek = ROI(Rect(Point(e.x * 1.1, e.y + e.height), Point((e.x + e.width), (e.y + 1.5 * e.height))));
					}
					else{
						if (ROI.data && face.x >= 0 && face.y >= 0 && face.width + face.x >= ROI.cols && face.height + face.y >= ROI.rows)
							cheek = ROI(Rect(Point(e.x * 1.05, e.y + e.height), Point((e.x + e.width), (e.y + 1.5 * e.height))));
					}
					if (cheek.data)
					{
						resize(cheek, cheek, Size(42, 42));
						imwrite(".\\Cheeks\\" + label + ".JPG", cheek);
					}
				}//End of Eyes for loop
				//double angle = atan((eye_point[0].y - eye_point[1].y) / (eye_point[0].x - eye_point[1].x)) * 180 / CV_PI;
				//cout << "Angle = " << angle << endl;
				//cout << j << " Eyes Detected\n";
				//Calculate distance between the two eyes
				//double dist = euclideanDist(eye_point[0], eye_point[1]);
				me = midPoint(eye_point[0], eye_point[1]);
				//Locating nose-bridge
				double dist = euclideanDistance(eye_point[0], eye_point[1]);
				double radius = dist / 4;
				Mat nose_bridge = ROI(Rect((me.x - radius), (me.y - radius), radius * 2, radius * 2));
				imwrite(".\\Nose-Bridge\\" + label + ".JPG", nose_bridge);
				circle(ROI, me, 3, Scalar(0, 255, 0), -1, 8);//visualize midpoint of eyes
				//line(ROI, eye_point[0], eye_point[1], Scalar(255, 0, 0));//Draw a line between the two eyes
				//cout << "Distance Between Eyes = " << dist << endl;
			}//End of Eyes if...

			// Detect nose if classifier provided by the user
			double nose_center_height = 0.0;
			if (!nose_cascade.empty())
			{
				Mat nasal;
				//string nasal_name = "nose.jpg";
				vector<Rect_<int> > nose;
				if (ROI.data && face.x >= 0 && face.y >= 0 && face.width + face.x >= ROI.cols && face.height + face.y >= ROI.rows)
					detectNose(ROI, nose, nose_cascade);

				// Mark points corresponding to the centre (tip) of the nose
				for (unsigned int j = 0; j < nose.size(); ++j)
				{
					n = nose[j];
					nose_center_height = (n.y + n.height / 2);
					//Draw rectangle around the nose
					//	rectangle(ROI, Point((n.x * 1.05), (n.y - 0.125 * n.height)), Point(n.x + n.width, n.y + n.height), Scalar(0, 255, 255), 1, 4);
					if (ROI.data && face.x >= 0 && face.y >= 0 && face.width + face.x >= ROI.cols && face.height + face.y >= ROI.rows)
						nasal = ROI(Rect((n.x * 1.05), (n.y - 0.125 * n.height), (0.925 * n.width), (n.height)));
					//nasal = ROI(Rect((n.x * 1.05), (n.y - 0.125 * n.height), (0.925* n.width), (2 * n.height)));

					if (nasal.data){
						no = Point(n.x + n.width / 2, n.y + n.height / 2);
						//circle(ROI, Point(n.x + n.width / 2, n.y + n.height / 2), 3, Scalar(0, 255, 0), -1, 8);//visualize the point
						//line(ROI, eye_point[0], no, Scalar(255, 0, 0));//Draw a line between eye and nose
						//line(ROI, eye_point[1], no, Scalar(255, 0, 0));//Draw a line between eye and nose
						resize(nasal, nasal, Size(45, 50));
						imwrite(".\\Noses\\" + label + ".JPG", nasal);
					}
				}//End of Nose for loop
				//line(ROI, Point(n.x + n.width / 2, n.y + n.height / 2), mid, Scalar(0, 0, 255));//Draw line between center of eyes and nose
				//Calculate vectors between mid and first eye and nose and mid eye
				//Point vec1 = getVector(Point(n.x + n.width / 2, n.y + n.height / 2), mid);
				//Point vec2 = getVector(eye_point[0], mid);
				//get angle between the two lines
				//double angle = angleBetween(vec1, vec2);
				//cout << "Face is rotated by " << angle << " degrees" << endl;
			}//End of Nose if...

			// Detect mouth if classifier provided by the user
			double mouth_center_height = 0.0;
			if (!mouth_cascade.empty())
			{
				Mat mouths;
				Mat mouths_bin;
				//string mouth_name = "mouth.jpg";
				vector<Rect_<int> > mouth;
				if (ROI.data && face.x >= 0 && face.y >= 0 && face.width + face.x >= ROI.cols && face.height + face.y >= ROI.rows)
					detectMouth(ROI, mouth, mouth_cascade);

				for (unsigned int j = 0; j < mouth.size(); ++j)
				{
					m = mouth[j];
					mouth_center_height = (m.y + m.height / 2);

					// The mouth should lie below the nose
					/*if ((is_full_detection) && (mouth_center_height > nose_center_height))
					{
					rectangle(ROI, Point(m.x, m.y), Point(m.x + m.width, m.y + m.height), Scalar(0, 0, 255), 1, 4);
					}
					else if ((is_full_detection) && (mouth_center_height <= nose_center_height))
					continue;
					else*/
					//rectangle(ROI, Point(m.x, m.y), Point(m.x + m.width, m.y + m.height), Scalar(0, 255, 0), 1, 4);
					if (ROI.data && face.x >= 0 && face.y >= 0 && face.width + face.x >= ROI.cols && face.height + face.y >= ROI.rows)
						mouths = ROI(Rect(m.x, m.y, m.width, 0.825 * m.height));
					//threshold(mouths, mouths_bin, 150, 255, THRESH_BINARY);
					if (mouths.data){
						//mo = Point(m.x + m.width / 2, m.y + m.height / 2);
						//circle(ROI, Point(m.x + m.width / 2, m.y + m.height / 2), 3, Scalar(0, 255, 0), -1, 8);//visualize the point
						//line(ROI, eye_point[0], mo, Scalar(255, 0, 0));//Draw a line between the eye and mouth
						//line(ROI, eye_point[1], mo, Scalar(255, 0, 0));//Draw a line between the eye and mouth
						resize(mouths, mouths, Size(100, 45));
						imwrite(".\\Mouth\\" + label + ".JPG", mouths);
					}
				}//End of Mouth for loop
			}//End of Mouth if...
			//Detect the fore head and draw rectangle ROI
			Mat forehead;
			//rectangle(ROI, Point(e.x + e.width, e.y - e.height), Point(e.width, e.height), Scalar(0, 255, 0), 1, 4); // Working good
			//rectangle(ROI, Point(mid.x - 1.25 * e.width, mid.y - 2 * e.height), Point(3 * e.width, e.height), Scalar(255, 255, 225), 1, 4);
			//if (ROI.data && face.x >= 0 && face.y >= 0 && face.width + face.x >= ROI.cols && face.height + face.y >= ROI.rows)
			forehead = ROI(Rect(Point(me.x + e.width, me.y - e.height), Point(e.width, e.height)));
			if (forehead.data){
				resize(forehead, forehead, Size(100, 30));
				fh = Point(me.x, me.y - e.height);
				//circle(ROI, Point(me.x, me.y - e.height), 3, Scalar(0, 255, 0), -1, 8);//visualize the point
				//line(ROI, mo, fh, Scalar(255, 0, 0));//Draw a line between mouth and forehead
				//line(ROI, no, fh, Scalar(255, 0, 0));//Draw a line between nose and forehead
				//line(ROI, me, fh, Scalar(255, 0, 0));//Draw a line between mid of eyes and forehead
				forehead = ROI(Rect(Point(e.x + e.width, e.y - e.height), Point(e.width, e.height)));
				imwrite(".\\Forehead\\" + label + ".JPG", forehead);
				//rectangle(ROI, Point(n.x - 0.5 * n.width, n.y - 3.5 * n.height), Point(3.5 * e.width, e.height), Scalar(255, 255, 225), 1, 4);
				//rectangle(ROI, Point(e.x + e.width, e.y - e.height), Point(e.width,e.height), Scalar(0, 255, 0), 1, 4); // Working good
				//imwrite(".\\Visual Lines\\" + label + ".JPG", ROI); //Save ROI
			}
			//getRatios(eye_point[0], eye_point[1], me, fh, no, mo, label);//for every image, get ratios and save them
		} // End of main outer for loop
		return;//NCENCENE
		///// error
	} //End of function detectFacialFeatures

	static void detectEyes(Mat& img, vector<Rect_<int> >& eyes, string cascade_path)
	{
		CascadeClassifier eyes_cascade;
		eyes_cascade.load(cascade_path);
		if (!(eyes_cascade.empty()))
			eyes_cascade.detectMultiScale(img, eyes, 1.20, 5, 0 | CASCADE_SCALE_IMAGE, Size(30, 30));
		return;
	}

	static void detectNose(Mat& img, vector<Rect_<int> >& nose, string cascade_path)
	{
		CascadeClassifier nose_cascade;
		nose_cascade.load(cascade_path);

		nose_cascade.detectMultiScale(img, nose, 1.20, 5, 0 | CASCADE_SCALE_IMAGE, Size(30, 30));
		return;
	}

	static void detectMouth(Mat& img, vector<Rect_<int> >& mouth, string cascade_path)
	{
		CascadeClassifier mouth_cascade;
		mouth_cascade.load(cascade_path);

		mouth_cascade.detectMultiScale(img, mouth, 1.20, 5, 0 | CASCADE_SCALE_IMAGE, Size(30, 30));
		return;
	}
	double euclideanDistance(Point left, Point right)
	{
		Point diff = left - right;

		return cv::sqrt(diff.x * diff.x + diff.y * diff.y);
	}
	Point midPoint(Point left, Point right)
	{
		return (left + right) * 0.5;
	}

};
#endif // DETECTFACIALFEATURES_H
